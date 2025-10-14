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
    public void setPosicao(int linha, int coluna) {
        this.posicao = new Posicao(linha, coluna);
        Tabuleiro.tabuleiro[linha][coluna] = "\uD83D\uDEE1\uFE0F";
    }
}
