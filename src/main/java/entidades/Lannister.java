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

    @Override
    public void setPosicao(int linha, int coluna) {
        this.posicao = new Posicao(linha, coluna);
        Tabuleiro.tabuleiro[linha][coluna] = this.getEscudo();
    }

    @Override
    public double atacar(Personagem inimigo) {
        double danoCausado = 0;
        if (checaDistancia(inimigo)) {
            System.out.println("Atacando " + inimigo.getClass().getSimpleName() + "!");
            danoCausado = inimigo.receberDano(this.ataqueBase * 1.15);
            System.out.println("Dano causado! Vida restante do inimigo: " + inimigo.getVida());
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
