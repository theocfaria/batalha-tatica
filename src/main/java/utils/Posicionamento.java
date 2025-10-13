package utils;

public class Posicionamento {
    private int linha;
    private int coluna;

    public Posicionamento(int linha, int coluna) {
        setPosicao(linha, coluna);
    }

    private void setLinha(int linha) {
        if(linha < 0 || linha > 9)
            this.linha = linha;
        else
            System.out.println("Linha inválida.");
    }
    private void setColuna(int coluna) {
        if(coluna < 0 || coluna > 9)
            this.coluna = coluna;
        else
            System.out.println("Coluna inválida.");
    }

    protected void setPosicao(int linha, int coluna) {
        setLinha(linha);
        setColuna(coluna);
    }
}
