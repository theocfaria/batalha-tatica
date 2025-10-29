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
        this.nomeCasa = "Stark";
        this.escudo = "\uD83D\uDEE1\uFE0F";
    }

    public double atacar(Tabuleiro tabuleiro, Personagem inimigo) {
        double danoCausado = 0;
        if (checaDistancia(inimigo)) {
            System.out.println("Atacando " + inimigo.getClass().getSimpleName() + "!");
            danoCausado = inimigo.receberDano(tabuleiro, this.ataqueBase);
            System.out.println("Dano causado! Vida restante do inimigo: " + inimigo.getVida());
        } else {
            System.out.println("Inimigo fora do alcance.");
        }
        return danoCausado;
    }

    @Override
    public double receberDano(Tabuleiro tabuleiro, double danoBruto) {
        double danoReduzido = danoBruto * 0.8;

        double danoFinal = danoReduzido - this.defesaBase;
        if (danoFinal < 0) danoFinal = 0;

        this.setVida(this.vida - danoFinal);
        if(this.getVida() <= 0) {
            this.morrer(tabuleiro);
            this.setVida(0);
        }

        return danoFinal;
    }

    @Override
    public String getNome(){
        return this.nomePersonagem;
    }
}
