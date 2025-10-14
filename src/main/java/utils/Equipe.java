package utils;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import entidades.Lannister;
import entidades.Stark;
import entidades.Tabuleiro;
import entidades.Targaryen;

public class Equipe {
    private Random rand = new Random();
    protected int integrantesVivos;
    public Personagem[] integrantes;
    ArrayList <Integer> linhasSorteadas = new ArrayList<>();
    protected int sorteiaLinha;
    protected int id;

    public Equipe(int id) {
        integrantesVivos = 3;
        integrantes = new Personagem[3];
        this.id = id;
        selecionarEquipe();
    }

    protected void selecionarEquipe() {

        System.out.println("Identificação equipe: "+ this.id);
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            System.out.println("Escolha a casa do " + (i+1) + "° integrante da sua equipe: (S)tark, (L)annister ou (T)argaryen");
            String casa = scanner.next();
            do {
                sorteiaLinha = rand.nextInt(10);
            }while(linhasSorteadas.contains(sorteiaLinha));
            linhasSorteadas.add(sorteiaLinha);
            switch (casa) {
                case "S": case "s":
                    integrantes[i] = new Stark(this);

                    if(this.id==1){
                        integrantes[i].setPosicao(sorteiaLinha, 0);
                    }else if(this.id==2){
                        integrantes[i].setPosicao(sorteiaLinha, 9);
                    }
                    break;

                case "L": case "l":
                    integrantes[i] = new Lannister(this);
                    if(this.id==1){
                        integrantes[i].setPosicao(sorteiaLinha, 0);
                    }else if(this.id==2){
                        integrantes[i].setPosicao(sorteiaLinha, 9);
                    }
                    break;

                case "T": case "t":
                    integrantes[i] = new Targaryen(this);
                    if(this.id==1){
                        integrantes[i].setPosicao(sorteiaLinha, 0);
                    }else if(this.id==2){
                        integrantes[i].setPosicao(sorteiaLinha, 9);
                    }
                    break;
            }
        }
    }

    public void escolheIntegrante(Equipe equipeInimiga) {
        Scanner sc = new Scanner(System.in);
        Tabuleiro.imprimirTabuleiro();
        System.out.println("Turno da Equipe " + this.id);
        System.out.print("Digite o índice do integrante que deseja mexer (0, 1 ou 2): ");
        int escolhido = sc.nextInt();
        while(escolhido < 0 || escolhido > 2){
            System.out.print("Índice inválido! Digite novamente o índice do integrante que deseja mexer: ");
            escolhido = sc.nextInt();
        }
        integrantes[escolhido].agir(equipeInimiga);
    }

    public boolean perdeu() {
        return integrantesVivos == 0;
    }

}
