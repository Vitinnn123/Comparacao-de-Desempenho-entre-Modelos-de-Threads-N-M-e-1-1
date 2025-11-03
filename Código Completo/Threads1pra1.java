public class Threads1pra1 {

    public static void main(String[] args) {
        int numThreads = 500;         // número de threads de usuário
        int iteracoes = 1_000_000;    // número de iterações da tarefa

        // imprime informações iniciais
        System.out.println("Teste Thread 1:1");
        System.out.println("Threads totais: " + numThreads);

        long inicio = System.currentTimeMillis(); // início da contagem de tempo

        Thread[] threads = new Thread[numThreads];

        // cria e inicia cada thread
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new TarefaTeste(i, iteracoes));
            threads[i].start();
        }

        // espera todas as threads terminarem
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long fim = System.currentTimeMillis(); // fim da contagem de tempo
        System.out.println("Tempo total: " + (fim - inicio) + " ms");
    }
}
