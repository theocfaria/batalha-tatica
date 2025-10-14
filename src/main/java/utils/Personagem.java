package utils;

import entidades.Tabuleiro;

public class Personagem {
    protected double vidaMaxima;
    protected double ataqueBase;
    protected double defesaBase;
    protected Posicao posicao;
    protected int alcance;

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
        Tabuleiro.tabuleiro[posicao.getLinha()][posicao.getColuna()] = "X";
    }
}
