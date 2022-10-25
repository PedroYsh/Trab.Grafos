import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Grafo g = new Grafo(5); // colocar o numero de vertices do grafo que esta usando
        g.graph = new int[g.n][g.n];
        g.ler_txt();
        Scanner sc = new Scanner(System.in);
        /*
         * System.out.println("\nDigite a Matriz\n");
         * g.graph = new int[g.n][g.n];
         * for (int i = 0; i < g.n; i++)
         * for (int j = 0; j < g.n; j++)
         * g.graph[i][j] = sc.nextInt();
         */

        System.out.println("Iniciando coloração");

        System.out.println("Numero de cores:");
        int c = sc.nextInt();

        g.ColoracaoGrafo(g.graph, c);
    }
}
