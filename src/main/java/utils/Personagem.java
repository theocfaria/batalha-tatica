package utils;

import entidades.Tabuleiro;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Personagem {
    protected double vida;
    protected double ataqueBase = 20.0;
    protected double defesaBase = 10.0;
    protected Posicao posicao;
    protected int alcance;
    protected Equipe equipe;

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(int linha, int coluna) {
        this.posicao = new Posicao(linha, coluna);
        Tabuleiro.tabuleiro[linha][coluna] = "X";
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public void printStatus() {
        System.out.println("Vida: " + this.vida);
        System.out.println("Ataque: " + this.ataqueBase);
        System.out.println("Defesa: " + this.defesaBase);
    }

    public void agir() {
        System.out.print("Digite 'w' para andar para ↑ \t");
        System.out.print("Digite 'q' para andar para ↖ \t");
        System.out.println("Digite 'e' para andar para ↗ ");
        System.out.print("Digite 'a' para andar para ←\t");
        System.out.print("Digite 'z' para andar para ↙  \t");
        System.out.println("Digite 's' para andar para ↓");
        System.out.print("Digite 'c' para andar para ↘  \t");
        System.out.print("Digite 'd' para andar para →\t");
        System.out.println("Digite 'f' para ⚔\uFE0F");
        Scanner scanner = new Scanner(System.in);
        String comando = scanner.next();
        switch(comando) {
            case "w":
                if(posicao.linha > 0) {
                    Tabuleiro.tabuleiro[this.posicao.linha][this.posicao.coluna] = " ";
                    this.setPosicao(this.getPosicao().linha - 1, this.getPosicao().coluna);
                }
                break;

            case "a":
                if(posicao.coluna > 0) {
                    Tabuleiro.tabuleiro[this.posicao.linha][this.posicao.coluna] = " ";
                    this.setPosicao(this.getPosicao().linha, this.getPosicao().coluna - 1);
                }
                break;

            case "s":
                if(posicao.linha < Tabuleiro.TAMANHO) {
                    Tabuleiro.tabuleiro[this.posicao.linha][this.posicao.coluna] = " ";
                    this.setPosicao(this.getPosicao().linha + 1, this.getPosicao().coluna);
                }
                break;

            case "d":
                if(posicao.coluna < Tabuleiro.TAMANHO) {
                    Tabuleiro.tabuleiro[this.posicao.linha][this.posicao.coluna] = " ";
                    this.setPosicao(this.getPosicao().linha, this.getPosicao().coluna + 1);
                }
                break;

            case "q":
                Tabuleiro.tabuleiro[this.posicao.linha][this.posicao.coluna] = " ";
                this.setPosicao(this.getPosicao().linha - 1, this.getPosicao().coluna - 1);
                break;

            case "e":
                Tabuleiro.tabuleiro[this.posicao.linha][this.posicao.coluna] = " ";
                this.setPosicao(this.getPosicao().linha - 1, this.getPosicao().coluna + 1);
                break;

            case "z":
                Tabuleiro.tabuleiro[this.posicao.linha][this.posicao.coluna] = " ";
                this.setPosicao(this.getPosicao().linha + 1, this.getPosicao().coluna - 1);
                break;

            case "c":
                Tabuleiro.tabuleiro[this.posicao.linha][this.posicao.coluna] = " ";
                this.setPosicao(this.getPosicao().linha + 1, this.getPosicao().coluna + 1);
                break;

            // case "f":
                // atacar()
                // break

            default:
                System.out.println("Comando inválido.");
                break;
        }
        if (posicao.linha < 0 || posicao.linha > 9 || posicao.coluna < 0 || posicao.coluna > 9) {
            System.out.println("Movimento inválido");
        }
    }

    public void atacar(Personagem inimigo) {
        if(inimigo.vida > 0) {
            inimigo.vida -= this.ataqueBase;
        }
    }
}
