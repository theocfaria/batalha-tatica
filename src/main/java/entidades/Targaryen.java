package entidades;

import utils.Equipe;
import utils.Personagem;
import utils.Posicao;

public class Targaryen extends Personagem {
    public Targaryen(Equipe equipe) {
        this.vida = 45.0;
        this.alcance = 3;
        this.equipe = equipe;
    }

    @Override
    public void setPosicao(int linha, int coluna) {
        this.posicao = new Posicao(linha, coluna);
        Tabuleiro.tabuleiro[linha][coluna] = "\uD83C\uDFF9";
    }
}
