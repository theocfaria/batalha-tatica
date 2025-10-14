package entidades;

import utils.Personagem;
import utils.Posicao;

public class Stark extends Personagem {
    public Stark() {
        this.vidaMaxima = 60.0;
        this.ataqueBase = 20.0;
        this.defesaBase = 10.0;
        this.alcance = 1;
    }

    @Override
    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
        Tabuleiro.tabuleiro[posicao.getLinha()][posicao.getColuna()] = "\uD83D\uDEE1\uFE0F";
    }
}
