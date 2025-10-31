package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import entidades.*;

public class Equipe {
    private Random rand = new Random();
    private int id;
    private List<Integer> linhasSorteadas = new ArrayList<>();
    private int integrantesVivos;
    private int sorteiaLinha;
    private Personagem[] integrantes;

    public Equipe(Tabuleiro tabuleiro, int id) {
        integrantesVivos = 3;
        integrantes = new Personagem[3];
        this.id = id;
        selecionarEquipe(tabuleiro);
    }

    public int getId(){ return this.id; }

    public Personagem getPersonagem(int idx){
        return integrantes[idx];
    }

    public Personagem[] getPersonagens() { return integrantes; }

    public void diminuiIntegrantes() { this.integrantesVivos--; }

    public boolean perdeu() {
        return integrantesVivos == 0;
    }

    public void selecionarEquipe(Tabuleiro tabuleiro) {
        if (this.id == 3) {
            List<String> casas = new ArrayList<>();
            casas.add("s");
            casas.add("l");
            casas.add("t");
            int i = 0;
            while (i < 3) {
                int escolhaCasa = rand.nextInt(casas.size());
                String casa = casas.get(escolhaCasa);
                String[] nomes = {"Theo", "Murilo", "Ryan", "Julia", "Gleiph", "Rogério", "Bighouse", "Clarisse", "Russo", "José", "Arnaldo", "Amanda", "Jorge", "Cristiano", "Pekka", "Zulu", "Evander", "Malaquias", "Cebolinha", "Pelé", "Rayane", "Ronaldo", "Totó", "Popó", "Wanderley", "Charles", "Tobias", "Diego", "Diego-MarquesLOKT", "Vilma", "Atílio"};
                int escolhaNome = rand.nextInt(nomes.length);
                do {
                    sorteiaLinha = rand.nextInt(10);
                } while (linhasSorteadas.contains(sorteiaLinha));
                linhasSorteadas.add(sorteiaLinha);
                switch (casa) {
                    case "s":
                        integrantes[i] = new Stark(this, nomes[escolhaNome]);
                        integrantes[i].setPosicao(tabuleiro, sorteiaLinha, 9);
                        i++;
                        break;

                    case "l":
                        integrantes[i] = new Lannister(this, nomes[escolhaNome]);
                        integrantes[i].setPosicao(tabuleiro, sorteiaLinha, 9);
                        i++;
                        break;

                    case "t":
                        integrantes[i] = new Targaryen(this, nomes[escolhaNome]);
                        integrantes[i].setPosicao(tabuleiro, sorteiaLinha, 9);
                        i++;
                        break;
                }
            }
        }
        else {
            System.out.println("Identificação equipe: " + this.id);
            Scanner scanner = new Scanner(System.in);
            int i = 0;
            while (i < 3) {
                System.out.println("Escolha a casa do " + (i + 1) + "° integrante da sua equipe: (S)tark, (L)annister ou (T)argaryen");
                char casa = scanner.next().toLowerCase().charAt(0);

                if (casa != 's' && casa != 'l' && casa != 't') {
                    System.out.println("Valor inválido, escolha novamente...");
                    continue;
                }

                do {
                    sorteiaLinha = rand.nextInt(10);
                } while (linhasSorteadas.contains(sorteiaLinha));
                linhasSorteadas.add(sorteiaLinha);
                String nomePersonagem;
                switch (casa) {
                    case 's':
                        System.out.println("Informe um nome para seu personagem: ");
                        nomePersonagem = scanner.next();
                        integrantes[i] = new Stark(this, nomePersonagem);

                        if (this.id == 1) {
                            integrantes[i].setPosicao(tabuleiro, sorteiaLinha, 0);
                        } else if (this.id == 2) {
                            integrantes[i].setPosicao(tabuleiro, sorteiaLinha, 9);
                        }
                        i++;
                        break;

                    case 'l':
                        System.out.println("Informe um nome para seu personagem: ");
                        nomePersonagem = scanner.next();
                        integrantes[i] = new Lannister(this, nomePersonagem);

                        if (this.id == 1) {
                            integrantes[i].setPosicao(tabuleiro, sorteiaLinha, 0);
                        } else if (this.id == 2) {
                            integrantes[i].setPosicao(tabuleiro, sorteiaLinha, 9);
                        }
                        i++;
                        break;

                    case 't':
                        System.out.println("Informe um nome para seu personagem: ");
                        nomePersonagem = scanner.next();
                        integrantes[i] = new Targaryen(this, nomePersonagem);

                        if (this.id == 1) {
                            integrantes[i].setPosicao(tabuleiro, sorteiaLinha, 0);
                        } else if (this.id == 2) {
                            integrantes[i].setPosicao(tabuleiro, sorteiaLinha, 9);
                        }
                        i++;
                        break;
                }
            }
        }
    }


    public int escolheIntegrante() {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {

            if (!getPersonagem(i).isMorto()){
                String vidaFormatada = String.format("%.2f", getPersonagem(i).getVida());
                System.out.println("Índice " + i + ": " + getPersonagem(i).getNome() + " - " + "[" + getPersonagem(i).getPosicao().getLinha() + ", " + getPersonagem(i).getPosicao().getColuna() + "] " + " - " +  getPersonagem(i).getEscudo() + " - " + "[Vida: " + vidaFormatada + "]");
            }
        }

        int escolhido = -1;
        System.out.println("Digite o índice do integrante que deseja mexer: ");
        while(escolhido < 0 || escolhido > 2 || getPersonagem(escolhido).isMorto()) {
            String escolha = sc.next();

            try {
                escolhido = Integer.parseInt(escolha);

                if(escolhido >= 0 && escolhido <= 2 && !getPersonagem(escolhido).isMorto()){
                    break;
                }
                System.out.println("Entrada inválida. Digite um índice válido");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um índice válido");
            }
        }
        return escolhido;
    }
}
