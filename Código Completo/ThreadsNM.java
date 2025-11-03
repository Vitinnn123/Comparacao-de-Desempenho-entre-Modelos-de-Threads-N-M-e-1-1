import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsNM {

    public static void main(String[] args) {
        int numTarefas = 500;         // número total de tarefas de usuário
        int numThreadsSistema = 10;   // número de threads do sistema (pool)
        int iteracoes = 1_000_000;    // número de iterações da tarefa

        // imprime informações iniciais
        System.out.println("Teste Thread N:M");
        System.out.println("Tarefas: " + numTarefas + " | Threads do sistema: " + numThreadsSistema);

        long inicio = System.currentTimeMillis(); // início da contagem de tempo

        // cria o pool de threads do sistema
        ExecutorService pool = Executors.newFixedThreadPool(numThreadsSistema);

        // envia as tarefas para o pool
        for (int i = 0; i < numTarefas; i++) {
            pool.execute(new TarefaTeste(i, iteracoes));
        }

        pool.shutdown(); // não aceita novas tarefas

        try {
            // espera todas as tarefas terminarem (até 2 minutos)
            pool.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fim = System.currentTimeMillis(); // fim da contagem de tempo
        System.out.println("Tempo total: " + (fim - inicio) + " ms");
    }
}
