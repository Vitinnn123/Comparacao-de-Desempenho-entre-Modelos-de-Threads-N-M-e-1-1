public class TarefaTeste implements Runnable {

    private final int id;        // id da thread só pra identificar no terminal
    private final int iteracoes; // quantas vezes a thread vai "trabalhar"

    // Construtor recebendo id e quantidade de iterações
    public TarefaTeste(int id, int iteracoes) {
        this.id = id;
        this.iteracoes = iteracoes;
    }

    @Override
    public void run() {
        System.out.println("Thread " + id + " iniciada!.");

        // loop pra simular carga de trabalho da thread
        for (int i = 1; i <= iteracoes; i++) {
            if (i <= 5) { // só imprime os primeiros pra não poluir o terminal
                System.out.println("Thread " + id + ": i = " + i);
            }
        }

        System.out.println("Thread " + id + " finalizada!.");
    }
}
