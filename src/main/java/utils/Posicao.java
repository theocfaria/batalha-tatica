package utils;
import entidades.Tabuleiro;

public class Posicao {
    private int linha;
    private int coluna;

    public Posicao(int linha, int coluna) {
        setLinha(linha);
        setColuna(coluna);
    }

    private void setLinha(int linha) {
        if(linha < 0 || linha > Tabuleiro.TAMANHO) {
            System.err.println("Linha inválida.");
        }
        else {
            this.linha = linha;
        }
    }

    public int getLinha() {
        return this.linha;
    }

    private void setColuna(int coluna) {
        if(coluna < 0 || coluna > Tabuleiro.TAMANHO) {
            System.err.println("Coluna inválida.");
        }
        else {
            this.coluna = coluna;
        }
    }

    public int getColuna() { return  this.coluna; }

    public static double distancia(Posicao p1, Posicao p2) {
        return Math.sqrt(Math.pow(p2.linha - p1.linha, 2.0f) + Math.pow(p2.coluna - p1.coluna, 2.0f));
    }
}
