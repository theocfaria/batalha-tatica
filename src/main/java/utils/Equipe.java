package utils;

import java.util.Scanner;

import entidades.Lannister;
import entidades.Stark;

public class Equipe {
    protected int integrantesVivos;
    protected Personagem[] integrantes;

    public Equipe() {
        integrantesVivos = 3;
        integrantes = new Personagem[3];
    }

    protected void selecionarEquipe() {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            System.out.println("Escolha a casa do " + i+1 + "° integrante da sua equipe: (S)tark, (L)annister ou (T)argaryen");
            String casa = scanner.next();
            switch (casa) {
                case "S": case "s":
                    integrantes[i] = new Stark(this);
                    break;

                case "L": case "l":
                    integrantes[i] = new Lannister(this);
                    break;
            }
        }
    }

}
