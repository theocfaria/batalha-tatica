package entidades;
import utils.Posicionamento;

public class Personagem {
    protected double vidaMaxima;
    protected double ataqueBase;
    protected double defesaBase;
    protected int alcance;
    protected Posicionamento posicao;
    protected int equipe;

    public void andar(int linha, int coluna) {

    }
    public void atacar(Personagem inimigo) {}

    public Posicionamento getPosicao() {
        return posicao;
    }

    protected void setPosicao(int linha, int coluna) {
        if((linha >= 0 && linha < 10) &&  (coluna >= 0 && coluna < 10)) {}
    }
}
