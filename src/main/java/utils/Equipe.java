package utils;

import java.util.ArrayList;
import java.util.List;
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
    List<Integer> linhasSorteadas = new ArrayList<>();
    protected int sorteiaLinha;
    public int id;

    public Equipe(int id) {
        integrantesVivos = 3;
        integrantes = new Personagem[3];
        this.id = id;
        selecionarEquipe();
    }

    protected void selecionarEquipe() {

        System.out.println("Identificação equipe: "+ this.id);
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while(i < 3) {
            System.out.println("Escolha a casa do " + (i+1) + "° integrante da sua equipe: (S)tark, (L)annister ou (T)argaryen");
            char casa = scanner.next().toLowerCase().charAt(0);

            if(casa != 's' && casa != 'l' && casa != 't'){
                System.out.println("Valor inválido, escolha novamente...");
                continue;
            }

            do {
                sorteiaLinha = rand.nextInt(10);
            }while(linhasSorteadas.contains(sorteiaLinha));
            linhasSorteadas.add(sorteiaLinha);
            String nomePersonagem;
            switch (casa) {
                case 's':
                    System.out.println("Informe um nome para seu personagem: ");
                    nomePersonagem = scanner.next();
                    integrantes[i] = new Stark(this, nomePersonagem);

                    if(this.id==1){
                        integrantes[i].setPosicao(sorteiaLinha, 0);
                    }else if(this.id==2){
                        integrantes[i].setPosicao(sorteiaLinha, 9);
                    }
                    i++;
                    break;

                case 'l':
                    System.out.println("Informe um nome para seu personagem: ");
                    nomePersonagem = scanner.next();
                    integrantes[i] = new Lannister(this, nomePersonagem);
                    if(this.id==1){
                        integrantes[i].setPosicao(sorteiaLinha, 0);
                    }else if(this.id==2){
                        integrantes[i].setPosicao(sorteiaLinha, 9);
                    }
                    i++;
                    break;

                case 't':
                    System.out.println("Informe um nome para seu personagem: ");
                    nomePersonagem = scanner.next();
                    integrantes[i] = new Targaryen(this, nomePersonagem);
                    if(this.id==1){
                        integrantes[i].setPosicao(sorteiaLinha, 0);
                    }else if(this.id==2){
                        integrantes[i].setPosicao(sorteiaLinha, 9);
                    }
                    i++;
                    break;
            }
        }
    }

    public Personagem[] getPersonagem(){
        return integrantes;
    }

    public void escolheIntegrante(Equipe equipeInimiga) {
        Scanner sc = new Scanner(System.in);
        Tabuleiro.imprimirTabuleiro();
        System.out.println("Turno da equipe: " + this.id);
       // System.out.println("Digite o índice do integrante que deseja mexer: ");
        for(int i = 0; i < 3; i++) {
            if (!getPersonagem()[i].morto)
                System.out.println("Indice " + i + ": " + getPersonagem()[i].getNome() + " - " + getPersonagem()[i].getNomeCasa());
        }

        int escolhido = -1;
        System.out.println("Digite o índice do integrante que deseja mexer: ");

        while(escolhido < 0 || escolhido > 2 || getPersonagem()[escolhido].morto) {
            String escolha = sc.next();

            try {
                escolhido = Integer.parseInt(escolha);

                if(escolhido >= 0 && escolhido <= 2 && !getPersonagem()[escolhido].morto){
                    break;
                }
                System.out.println("Entrada inválida. Digite um índice válido");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um índice válido");
            }
        }
        integrantes[escolhido].agir(equipeInimiga);
    }

    public boolean perdeu() {
        return integrantesVivos == 0;
    }

}
