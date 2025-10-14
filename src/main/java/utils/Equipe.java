package utils;

import java.util.Scanner;
import java.util.Random;

import entidades.Lannister;
import entidades.Stark;
import entidades.Targaryen;

public class Equipe {
    protected int integrantesVivos;
    public Personagem[] integrantes;

    public Equipe() {
        integrantesVivos = 3;
        integrantes = new Personagem[3];
        selecionarEquipe();
    }

    protected void selecionarEquipe() {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            System.out.println("Escolha a casa do " + (i+1) + "° integrante da sua equipe: (S)tark, (L)annister ou (T)argaryen");
            String casa = scanner.next();
            switch (casa) {
                case "S": case "s":
                    integrantes[i] = new Stark(this);
                    integrantes[i].setPosicao(i, 0);
                    break;

                case "L": case "l":
                    integrantes[i] = new Lannister(this);
                    integrantes[i].setPosicao(i, 0);
                    break;

                case "T": case "t":
                    integrantes[i] = new Targaryen(this);
                    integrantes[i].setPosicao(i, 0);
                    break;
            }
        }
    }

    public void escolheIntegrante() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o índice do integrante que deseja mexer: ");
        int escolhido = sc.nextInt();
        while(escolhido < 0 || escolhido > 2){
            System.out.print("Índice inválido! Digite novamente o índice do integrante que deseja mexer: ");
            escolhido = sc.nextInt();
        }
        integrantes[escolhido].agir();
    }

    public boolean perdeu() {
        return integrantesVivos == 0;
    }

}
