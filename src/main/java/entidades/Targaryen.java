package entidades;

import utils.Equipe;
import utils.Personagem;
import utils.Posicao;

public class Targaryen extends Personagem {
    public Targaryen(Equipe equipe, String nomePersonagem) {
        this.vida = 45.0;
        this.alcance = 3;
        this.equipe = equipe;
        this.nomePersonagem = nomePersonagem;
        this.nomeCasa = "Targaryen";
        this.escudo = "\uD83C\uDFF9";
    }

    public double atacar(Tabuleiro tabuleiro, Personagem inimigo) {
        double danoCausado = 0;
        if (checaDistancia(inimigo)) {
            System.out.println("Atacando " + inimigo.getClass().getSimpleName() + "!");
            danoCausado = inimigo.receberDano(tabuleiro,this.ataqueBase + inimigo.getDefesa());
            System.out.println("Dano causado! Vida restante do inimigo: " + inimigo.getVida());
        } else {
            System.out.println("Inimigo fora do alcance.");
        }
        return danoCausado;
    }

    @Override
    public String getNome() {
        return this.nomePersonagem;
    }
}
