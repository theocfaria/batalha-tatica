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
    }

    @Override
    public void setPosicao(int linha, int coluna) {
        this.posicao = new Posicao(linha, coluna);
        Tabuleiro.tabuleiro[linha][coluna] = "\uD83C\uDFF9";
    }

    @Override
    public void atacar(Personagem inimigo) {
       if (checaDistancia(inimigo)) {
            System.out.println("Atacando " + inimigo.getClass().getSimpleName() + "!");
            inimigo.receberDano(this.ataqueBase  + inimigo.getDefesa());
            System.out.println("Dano causado! Vida restante do inimigo: " + inimigo.getVida());
       } else {
           System.out.println("Inimigo fora do alcance.");
       }
    }

    @Override
    public String getNome(){
        return this.nomePersonagem;
    }

    @Override
    public String getNomeCasa(){
        return "Targaryen";
    }
}
