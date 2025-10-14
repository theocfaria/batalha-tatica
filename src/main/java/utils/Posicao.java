package utils;
import entidades.Tabuleiro;

public class Posicao {
    protected int linha;
    protected int coluna;

    public Posicao(int linha, int coluna) {
        setLinha(linha);
        setColuna(coluna);
    }

    private void setLinha(int linha) {
        if(linha < 0 || linha > Tabuleiro.TAMANHO) {
            System.err.println("Linha inválida.");
            return;
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
            return;
        }
        else {
            this.coluna = coluna;
        }
    }

    public int getColuna() { return  this.coluna; }
}
