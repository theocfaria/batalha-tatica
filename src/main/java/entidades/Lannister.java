package entidades;

import utils.Equipe;
import utils.Personagem;
import utils.Posicao;

public class Lannister extends Personagem {
    public Lannister(Equipe equipe, String nomePersonagem) {
        this.vida = 50.0;
        this.alcance = 2;
        this.equipe = equipe;
        this.nomePersonagem = nomePersonagem;
        this.nomeCasa = "Lannister";
        this.escudo = "\uD83D\uDDE1\uFE0F";
    }

    public Double atacar(Tabuleiro tabuleiro, Personagem inimigo) {
        double danoCausado = 0;
        if (checaDistancia(inimigo)) {
            System.out.println("Atacando " + inimigo.getNome() + "!");
            danoCausado = inimigo.receberDano(tabuleiro,this.ataqueBase * 1.15);
            String vidaFormatada = String.format("%.2f", inimigo.getVida());
            System.out.println("Dano causado! Vida restante do inimigo: " + vidaFormatada);
        } else {
            System.out.println("Inimigo fora do alcance.");
        }
        return danoCausado;
    }

    @Override
    public String getNome(){
        return this.nomePersonagem;
    }

    @Override
    public String getNomeCasa(){
        return "Lannister";
    }
}
