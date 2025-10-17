package entidades;

import utils.Personagem;
import utils.Equipe;
import utils.Posicao;

public class Stark extends Personagem {
    public Stark(Equipe equipe, String nomePersonagem) {
        this.vida = 60.0;
        this.alcance = 1;
        this.equipe = equipe;
        this.nomePersonagem = nomePersonagem;
    }

    @Override
    public void atacar(Personagem inimigo) {
        if (checaDistancia(inimigo)) {
            System.out.println("Atacando " + inimigo.getClass().getSimpleName() + "!");
            inimigo.receberDano(this.ataqueBase);
            System.out.println("Dano causado! Vida restante do inimigo: " + inimigo.getVida());
        } else {
            System.out.println("Inimigo fora do alcance.");
        }
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
        return this.nomePersonagem;
    }

    @Override
    public String getNomeCasa(){
        return "Stark";
    }
}
