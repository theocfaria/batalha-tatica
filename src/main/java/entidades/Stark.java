package entidades;

import utils.Personagem;
import utils.Equipe;
import utils.Posicao;

public class Stark extends Personagem {
    public Stark(Equipe equipe) {
        this.vida = 60.0;
        this.alcance = 1;
        this.equipe = equipe;
    }

    @Override
    public void setPosicao(int linha, int coluna) {
        this.posicao = new Posicao(linha, coluna);
        Tabuleiro.tabuleiro[linha][coluna] = "\uD83D\uDEE1\uFE0F";
    }

    @Override
    public void receberDano(double danoBruto) {
        double danoReduzido = danoBruto * 0.8;

        double danoFinal = danoReduzido - this.defesaBase;
        if (danoFinal < 0) danoFinal = 0;

        this.setVida(this.vida - danoFinal);
    }

    @Override
    public String getNome(){
        return "Stark";
    }
}
