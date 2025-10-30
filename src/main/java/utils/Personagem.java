package utils;

import entidades.Tabuleiro;
import replay.Jogada;

import java.util.HashMap;
import java.util.Map;
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
    protected String nomePersonagem;
    protected String nomeCasa;
    public String escudo;

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Tabuleiro tabuleiro, int linha, int coluna) {
        this.posicao = new Posicao(tabuleiro, linha, coluna);
        tabuleiro.tabuleiro[linha][coluna] = this.getEscudo();
    }

    protected void setVida(double vida) {
        this.vida = vida;
    }

    public double getVida() { return this.vida; }

    public String getApresentacao() {return this.nomePersonagem + " da casa " + this.nomeCasa;}

    public double getDefesa() { return this.defesaBase; }

    public String getEscudo() { return this.escudo; }

    public String getNomeCasa(){
        return this.nomeCasa;
    }

    public String getNome() {
        return this.nomePersonagem;
    }

    public boolean checaColisao(Tabuleiro tabuleiro, int linha, int coluna){
        if(Objects.equals(tabuleiro.tabuleiro[linha][coluna], "")){
            return false;
        }
        return true;
    }



    public Jogada agir(Tabuleiro tabuleiro, Equipe equipeInimiga) throws InterruptedException {
        if(this.morto)
            return null;

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
                    if(checaColisao(tabuleiro, lin - 1, col)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }

                    tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(tabuleiro, this.getPosicao().getLinha() - 1, this.getPosicao().getColuna());
                    return new Jogada( this, "andou", null, "para o norte", tabuleiro);

                case "a":
                    if(col == 0){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(tabuleiro, lin, col - 1)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(tabuleiro, this.getPosicao().getLinha(), this.getPosicao().getColuna() - 1);
                    return new Jogada(this, "andou", null, "para o oeste", tabuleiro);


                case "s":
                    if(lin == 9){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(tabuleiro, lin + 1, col)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(tabuleiro, this.getPosicao().getLinha() + 1, this.getPosicao().getColuna());
                    return new Jogada(this, "andou", null, "para o sul", tabuleiro);


                case "d":
                    if(col == 9){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(tabuleiro, lin, col + 1)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(tabuleiro, this.getPosicao().getLinha(), this.getPosicao().getColuna() + 1);
                    return new Jogada(this, "andou", null, "para a leste", tabuleiro);


                case "q":
                    if(lin == 0 || col == 0){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(tabuleiro, lin - 1, col - 1)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(tabuleiro, this.getPosicao().getLinha() - 1, this.getPosicao().getColuna() - 1);
                    return new Jogada(this, "andou", null, "para o noroeste", tabuleiro);


                case "e":
                    if(lin == 0 || col == 9 ){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(tabuleiro, lin - 1, col + 1)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(tabuleiro, this.getPosicao().getLinha() - 1, this.getPosicao().getColuna() + 1);
                    return new Jogada(this, "andou", null, "para o nordeste", tabuleiro);

                case "z":
                    if(lin == 9 || col == 0){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(tabuleiro, lin + 1, col - 1)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(tabuleiro, this.getPosicao().getLinha() + 1, this.getPosicao().getColuna() - 1);
                    return new Jogada(this, "andou", null, "para o sudoeste", tabuleiro);

                case "c":
                    if(lin == 9 || this . getPosicao().getColuna() == 9){
                        System.out.println("Não é possível andar mais nessa direção.");
                        continue;
                    }
                    if(checaColisao(tabuleiro, lin + 1, col + 1)){
                        System.out.println("Já existe um personagem nessa casa...");
                        continue;
                    }
                    tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
                    this.setPosicao(tabuleiro, this.getPosicao().getLinha() + 1, this.getPosicao().getColuna() + 1);
                    return new Jogada(this, "andou", null, "para o sudeste", tabuleiro);

                case "f":
                    System.out.println("Escolha um inimigo para atacar:");
                    Map<Integer, Boolean> atacaveis = new HashMap<>();
                    int qntAtacaveis = 0;
                    for (int i = 0; i < equipeInimiga.integrantes.length; i++) {
                        Personagem inimigo = equipeInimiga.integrantes[i];
                        atacaveis.put(i, inimigo.getVida() > 0 && checaDistancia(inimigo));
                        if (inimigo.getVida() > 0 && checaDistancia(inimigo)) {
                            qntAtacaveis++;
                            String vidaFormatada = String.format("%.2f", inimigo.getVida());
                            System.out.println(i + ": " + inimigo.getNome() +
                                    " (Vida: " + vidaFormatada +
                                    ", Posição: [" + inimigo.getPosicao().getLinha() + "," + inimigo.getPosicao().getColuna() + "])");
                        }
                    }
                    if(qntAtacaveis == 0){
                        System.out.println("Não há nenhum inimigo em sua área de ataque, realize outra ação.");
                        continue;
                    }

                    System.out.print("Digite o índice do inimigo: ");
                    int indiceAlvo;
                    indiceAlvo = scanner.nextInt();

                    while (!atacaveis.containsKey(indiceAlvo) || !atacaveis.get(indiceAlvo)) {
                        System.out.print("Índice inválido! Digite novamente o índice do integrante que deseja atacar: ");
                        indiceAlvo = scanner.nextInt();
                    }

                    Personagem alvo = equipeInimiga.integrantes[indiceAlvo];
                    Double danoCausado = atacar(tabuleiro, alvo);

                    Thread.sleep(2000);

                    return new Jogada(this, "atacou", alvo, danoCausado.toString(), tabuleiro);


                default:
                    System.out.println("Comando inválido.");
                    continue;
            }
        }
        return null;
    }

    public Double atacar(Tabuleiro tabuleiro, Personagem alvo) { return 0.0; }

    public double receberDano(Tabuleiro tabuleiro, double danoBruto) {
        double danoFinal = danoBruto - this.defesaBase;

        if (danoFinal < 0) {
            danoFinal = 0;
        }

        this.setVida(this.vida - danoFinal);
        if(this.getVida() <= 0) {
            this.morrer(tabuleiro);
            this.setVida(0);
        }

        return danoFinal;
    }

    public Personagem checaAlcance(Equipe equipeInimiga) {
        Personagem maisPerto = null;
        for (Personagem inimigo : equipeInimiga.getPersonagens()) {
            if (inimigo.morto) {
                continue;
            }

            if (checaDistancia(inimigo)) {
                if (maisPerto == null) {
                    maisPerto = inimigo;
                } else {
                    if (Posicao.distancia(this.posicao, inimigo.posicao) < Posicao.distancia(this.posicao, maisPerto.posicao)) {
                        maisPerto = inimigo;
                    }
                }
            }
        }

        return maisPerto;
    }

    public boolean checaDistancia(Personagem inimigo) {
        return Posicao.distancia(this.posicao, inimigo.posicao) <= this.alcance;
    }

    protected void morrer(Tabuleiro tabuleiro) {
        tabuleiro.tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()] = "";
        this.equipe.integrantesVivos--;
        this.morto = true;
    }
}
