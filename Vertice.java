public class Vertice {
    public int num;
    public String cor;

    public Vertice(int num) {
        this.num = num;
        this.cor = "cinza";
    }

    public int getN() {
        return num;
    }

    public void setN(int n) {
        this.num = n;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

}
