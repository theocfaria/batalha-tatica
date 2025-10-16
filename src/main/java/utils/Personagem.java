package utils;

import entidades.Tabuleiro;

import java.util.Objects;
import java.util.Scanner;

public abstract class Personagem {
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

    protected void setVida(double vida) {
        this.vida = vida;
    }

    public double getVida() { return this.vida; }

    public double getDefesa() { return this.defesaBase; }

    public void printStatus() {
        System.out.println("Vida: " + this.vida);
        System.out.println("Ataque: " + this.ataqueBase);
        System.out.println("Defesa: " + this.defesaBase);
    }

    private boolean checaColisao(int linha, int coluna){
        if(Objects.equals(Tabuleiro.tabuleiro[linha][coluna], "")){
            return false;
        }
        return true;
    }
    
    public void agir() {
        boolean andou = false;

        while(!andou){
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
            
            int lin = this.posicao.getLinha();
            int col = this.posicao.getColuna();
            
            switch(comando) {
                case "w":
                    if(lin == 0){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(lin - 1, col)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }

                    Tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(this.getPosicao().getLinha() - 1, this.getPosicao().getColuna());

                    break;

                case "a":
                    if(col == 0){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(lin, col - 1)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    Tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(this.getPosicao().getLinha(), this.getPosicao().getColuna() - 1);


                    break;

                case "s":
                    if(lin == 9){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(lin + 1, col)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    Tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(this.getPosicao().getLinha() + 1, this.getPosicao().getColuna());

                    break;

                case "d":
                    if(col == 9){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(lin, col + 1)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    Tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(this.getPosicao().getLinha(), this.getPosicao().getColuna() + 1);

                    break;

                case "q":
                    if(lin == 0 || col == 0){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(lin - 1, col - 1)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    Tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(this.getPosicao().getLinha() - 1, this.getPosicao().getColuna() - 1);
                    break;

                case "e":
                    if(lin == 0 || col == 9 ){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(lin - 1, col + 1)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    Tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(this.getPosicao().getLinha() - 1, this.getPosicao().getColuna() + 1);
                    break;

                case "z":
                    if(lin == 9 || col == 0){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(lin + 1, col - 1)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    Tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(this.getPosicao().getLinha() + 1, this.getPosicao().getColuna() - 1);
                    break;

                case "c":
                    if(lin == 9 || this . getPosicao().getColuna() == 9){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(lin + 1, col + 1)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    Tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(this.getPosicao().getLinha() + 1, this.getPosicao().getColuna() + 1);
                    break;

                // case "f":
                // atacar()
                // break

                default:
                    System.out.println("Comando inválido.");
                    continue;
            }
            andou = true;
        }
    }

    public void atacar(Personagem inimigo) {
        if(inimigo.vida > 0) {
            if(checaDistancia(inimigo))
                inimigo.receberDano(this.ataqueBase);
            else
                System.out.println("Inimigo fora do alcance. ");
        }
        else {
            System.out.println("Inimigo já morreu.");
        }
    }

    public void receberDano(double danoBruto) {
        double danoFinal = danoBruto - this.defesaBase;

        if (danoFinal < 0) {
            danoFinal = 0;
        }

        this.setVida(this.vida - danoFinal);
    }

    protected boolean checaDistancia(Personagem inimigo) {
        return Posicao.distancia(this.posicao, inimigo.posicao) < this.alcance;
    }
}
