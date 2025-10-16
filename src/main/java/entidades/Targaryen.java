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

    @Override
    public void atacar(Personagem inimigo) {
        if (inimigo.equipe.id == this.equipe.id) {
            System.out.println("Você não pode atacar um membro da sua própria equipe!");
            return;
        }

        if (inimigo.getVida() <= 0) {
            System.out.println("O alvo já está derrotado.");
            return;
        }
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
        return "Targaryen";
    }
}
