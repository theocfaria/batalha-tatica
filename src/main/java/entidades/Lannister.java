package entidades;

import utils.Equipe;
import utils.Personagem;
import utils.Posicao;

public class Lannister extends Personagem {
    public Lannister(Equipe equipe) {
        this.vida = 50.0;
        this.alcance = 2;
        this.equipe = equipe;
    }

    @Override
    public void setPosicao(int linha, int coluna) {
        this.posicao = new Posicao(linha, coluna);
        Tabuleiro.tabuleiro[linha][coluna] = "\uD83D\uDDE1\uFE0F";
    }

    @Override
    public void atacar(Personagem inimigo) {
        if (checaDistancia(inimigo)) {
            System.out.println("Atacando " + inimigo.getClass().getSimpleName() + "!");
            inimigo.receberDano(this.ataqueBase * 1.15);
            System.out.println("Dano causado! Vida restante do inimigo: " + inimigo.getVida());
        } else {
            System.out.println("Inimigo fora do alcance.");
        }
    }

    @Override
    public String getNome(){
        return "Lannister";
    }
}
