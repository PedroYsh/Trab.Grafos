
import java.io.File;
//import java.io.IOException;
import java.util.Scanner;
//import java.io.FileNotFoundException;
//import java.util.Arrays;
import java.util.ArrayList;

public class Grafo {
    public int graph[][];
    public int n;
    public ArrayList<Vertice> vertices = new ArrayList();
    // public ArrayList<Vertice> ts = new ArrayList();
    // public int tempo;
    public int[] cor; // array para armazenar as cores de respectivos vertices
    public int nume; // numero de cores

    public void ler_txt() {
        try {
            Scanner sc = new Scanner(new File("C:\\Trab02\\Planar.txt"));
            while (sc.hasNextLine()) {
                for (int i = 0; i < this.n; i++) {
                    String[] linha = sc.nextLine().trim().split(",");
                    // trim --> tira os espaços do final e no fim da string(linha inteira)
                    // split --> para cada delimitador especificado, separa a string maior em varias
                    // outras menores
                    for (int j = 0; j < this.n; j++) {
                        this.graph[i][j] = Integer.parseInt(linha[j]);
                    }
                }
            }
            sc.close();
        } catch (Exception error) {
            System.out.println("Erro: " + error);
        }
    }

    public Grafo(int n) {
        this.n = n;
        int i;
        for (i = 1; i <= n; i++) {
            Vertice v = new Vertice(i);
            vertices.add(v);
        }
    }

    public void ColoracaoGrafo(int[][] graph, int ncor) {
        cor = new int[this.n];
        nume = ncor;

        try {
            Colorir(0);
            System.out.println("\nImpossivel");
        } catch (Exception e) {
            System.out.println("\nPossivel ");
            printaCor(cor);
        }
    }

    public void Colorir(int v) throws Exception {
        if (v == this.n) {
            throw new Exception("Certo");
        }

        for (int c = 1; c <= nume; c++) {
            if (corvalida(v, c)) {
                cor[v] = c;
                Colorir(v + 1);

                cor[v] = 0;
            }

        }
    }

    public boolean corvalida(int v, int c) {
        for (int i = 0; i < n; i++)
            if (graph[v][i] == 1 && c == cor[i])
                return false;
        return true;
    }

    public void printaCor(int[] cor) {
        System.out.print("Cores:\n");
        for (int i = 0; i < n; i++) {
            if (cor[i] == 1) {
                vertices.get(i).cor = "Preto/Cortinas";
            } else if (cor[i] == 2) {
                vertices.get(i).cor = "Verde/Peppas";
            } else if (cor[i] == 3) {
                vertices.get(i).cor = "Branco/Jovens Velhos";
            } else if (cor[i] == 4) {
                vertices.get(i).cor = "Vermelho/Saint Paul";
            }

            System.out.println("Bar[" + vertices.get(i).num + "] -->cor:" + vertices.get(i).cor);
        }
    }
}
