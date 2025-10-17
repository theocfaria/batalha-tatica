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
    public Equipe equipe;
    public boolean morto = false;
    private String nomeCasa;

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(int linha, int coluna) {}

    protected void setVida(double vida) {
        this.vida = vida;
    }

    public double getVida() { return this.vida; }

    public double getDefesa() { return this.defesaBase; }

    private boolean checaColisao(int linha, int coluna){
        if(Objects.equals(Tabuleiro.tabuleiro[linha][coluna], "")){
            return false;
        }
        return true;
    }


    public void agir(Equipe equipeInimiga) {
        if(this.morto)
            return;

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

            case "f":
                System.out.println("Escolha um inimigo para atacar:");
                for (int i = 0; i < equipeInimiga.integrantes.length; i++) {
                    Personagem inimigo = equipeInimiga.integrantes[i];
                    if (inimigo.getVida() > 0) {
                        System.out.println(i + ": " + inimigo.getClass().getSimpleName() +
                                " (Vida: " + inimigo.getVida() +
                                ", Posição: [" + inimigo.getPosicao().getLinha() + "," + inimigo.getPosicao().getColuna() + "])");
                    }
                }

                System.out.print("Digite o índice do inimigo: ");
                int indiceAlvo;
                indiceAlvo = scanner.nextInt();

                while (indiceAlvo < 0 || indiceAlvo >2) {
                    System.out.print("Índice inválido! Digite novamente o índice do integrante que deseja atacar: ");
                    indiceAlvo = scanner.nextInt();
                }

                if (indiceAlvo >= 0 && indiceAlvo < equipeInimiga.integrantes.length) {
                    Personagem alvo = equipeInimiga.integrantes[indiceAlvo];
                    atacar(alvo);
                } else {
                    System.out.println("Índice inválido.");
                }
                break;

                default:
                    System.out.println("Comando inválido.");
                    continue;
            }
            andou = true;
        }
    }

    public void atacar(Personagem inimigo) {}

    public void receberDano(double danoBruto) {
        double danoFinal = danoBruto - this.defesaBase;

        if (danoFinal < 0) {
            danoFinal = 0;
        }

        this.setVida(this.vida - danoFinal);
        if(this.getVida() <= 0) {
            this.morrer();
            this.setVida(0);
        }
    }

    protected boolean checaDistancia(Personagem inimigo) {
        return Posicao.distancia(this.posicao, inimigo.posicao) <= this.alcance;
    }


    protected void morrer() {
        Tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
        this.equipe.integrantesVivos--;
        this.morto = true;
    }

    protected String getNome() {
        return this.nomeCasa;
    }
}
