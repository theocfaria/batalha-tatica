package utils;

public class Posicao {
    private int linha;
    private int coluna;

    public Posicao(Tabuleiro tabuleiro, int linha, int coluna) {
        setLinha(tabuleiro, linha);
        setColuna(tabuleiro, coluna);
    }

    private void setLinha(Tabuleiro tabuleiro, int linha) {
        if(linha < 0 || linha > tabuleiro.TAMANHO) {
            System.err.println("Linha inválida.");
        }
        else {
            this.linha = linha;
        }
    }

    public int getLinha() {
        return this.linha;
    }

    private void setColuna(Tabuleiro tabuleiro, int coluna) {
        if(coluna < 0 || coluna > tabuleiro.TAMANHO) {
            System.err.println("Coluna inválida.");
        }
        else {
            this.coluna = coluna;
        }
    }

    public int getColuna() { return this.coluna; }

    public static double distancia(Posicao p1, Posicao p2) {
        return Math.sqrt(Math.pow(p2.linha - p1.linha, 2.0f) + Math.pow(p2.coluna - p1.coluna, 2.0f));
    }
}
