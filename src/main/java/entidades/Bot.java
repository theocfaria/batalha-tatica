package entidades;

import replay.Jogada;
import utils.Equipe;
import utils.Personagem;
import entidades.Tabuleiro;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bot {

    public static Jogada joga(Tabuleiro tabuleiro, Equipe equipe, Equipe equipeInimiga){
        for(int i = 0; i < 3; i++) {
            if (!equipe.getPersonagem(i).morto){
                String vidaFormatada = String.format("%.2f", equipe.getPersonagem(i).getVida());
                System.out.println("Índice " + i + ": " + equipe.getPersonagem(i).getNome() + " - " + "[" + equipe.getPersonagem(i).getPosicao().getLinha() + ", " + equipe.getPersonagem(i).getPosicao().getColuna() + "] " + " - " +  equipe.getPersonagem(i).getEscudo() + " - " + "[Vida: " + vidaFormatada + "]");
            }
        }
        Random rand = new Random();
        int idxPersonagem;
        do{
            idxPersonagem = rand.nextInt(3);
        }while(equipe.getPersonagem(idxPersonagem).morto);

        Personagem personagemAtual = equipe.getPersonagem(idxPersonagem);
        return escolheAcao(personagemAtual ,tabuleiro, equipeInimiga);
    }

    private static Jogada escolheAcao(Personagem personagemAtual, Tabuleiro tabuleiro, Equipe equipeInimiga){

        String[] acoes = {"q","w","e","a","s","d","z","c"};

        int lin = personagemAtual.getPosicao().getLinha();
        int col = personagemAtual.getPosicao().getColuna();

        boolean escolheu = false;

        while(!escolheu) {

            Random rand = new Random();
            int idxAcao = rand.nextInt(8);
            String comando = acoes[idxAcao];

            if(personagemAtual.checaAlcance(equipeInimiga) != null){

                Personagem alvo = personagemAtual.checaAlcance(equipeInimiga);

                Double danoCausado = personagemAtual.atacar(tabuleiro, alvo);

                return new Jogada(personagemAtual, "atacou", alvo, danoCausado.toString(), tabuleiro);
            }

            switch (comando) {
                case "w":
                    if (lin == 0) {
                        continue;
                    }
                    if (personagemAtual.checaColisao(tabuleiro, lin - 1, col)) {
                        continue;
                    }

                    tabuleiro.tabuleiro[personagemAtual.getPosicao().getLinha()][personagemAtual.getPosicao().getColuna()] = "";
                    personagemAtual.setPosicao(tabuleiro, personagemAtual.getPosicao().getLinha() - 1, personagemAtual.getPosicao().getColuna());
                    return new Jogada(personagemAtual, "andou", null, "para o norte", tabuleiro);

                case "a":
                    if (col == 0) {
                        continue;
                    }
                    if (personagemAtual.checaColisao(tabuleiro, lin, col - 1)) {
                        continue;
                    }
                    tabuleiro.tabuleiro[personagemAtual.getPosicao().getLinha()][personagemAtual.getPosicao().getColuna()] = "";
                    personagemAtual.setPosicao(tabuleiro, personagemAtual.getPosicao().getLinha(), personagemAtual.getPosicao().getColuna() - 1);
                    return new Jogada(personagemAtual, "andou", null, "para o oeste", tabuleiro);


                case "s":
                    if (lin == 9) {
                        continue;
                    }
                    if (personagemAtual.checaColisao(tabuleiro, lin + 1, col)) {
                        continue;
                    }
                    tabuleiro.tabuleiro[personagemAtual.getPosicao().getLinha()][personagemAtual.getPosicao().getColuna()] = "";
                    personagemAtual.setPosicao(tabuleiro, personagemAtual.getPosicao().getLinha() + 1, personagemAtual.getPosicao().getColuna());
                    return new Jogada(personagemAtual, "andou", null, "para o sul", tabuleiro);


                case "d":
                    if (col == 9) {
                        continue;
                    }
                    if (personagemAtual.checaColisao(tabuleiro, lin, col + 1)) {
                        continue;
                    }
                    tabuleiro.tabuleiro[personagemAtual.getPosicao().getLinha()][personagemAtual.getPosicao().getColuna()] = "";
                    personagemAtual.setPosicao(tabuleiro, personagemAtual.getPosicao().getLinha(), personagemAtual.getPosicao().getColuna() + 1);
                    return new Jogada(personagemAtual, "andou", null, "para a leste", tabuleiro);


                case "q":
                    if (lin == 0 || col == 0) {
                        continue;
                    }
                    if (personagemAtual.checaColisao(tabuleiro, lin - 1, col - 1)) {
                        continue;
                    }
                    tabuleiro.tabuleiro[personagemAtual.getPosicao().getLinha()][personagemAtual.getPosicao().getColuna()] = "";
                    personagemAtual.setPosicao(tabuleiro, personagemAtual.getPosicao().getLinha() - 1, personagemAtual.getPosicao().getColuna() - 1);
                    return new Jogada(personagemAtual, "andou", null, "para o noroeste", tabuleiro);


                case "e":
                    if (lin == 0 || col == 9) {
                        continue;
                    }
                    if (personagemAtual.checaColisao(tabuleiro, lin - 1, col + 1)) {
                        continue;
                    }
                    tabuleiro.tabuleiro[personagemAtual.getPosicao().getLinha()][personagemAtual.getPosicao().getColuna()] = "";
                    personagemAtual.setPosicao(tabuleiro, personagemAtual.getPosicao().getLinha() - 1, personagemAtual.getPosicao().getColuna() + 1);
                    return new Jogada(personagemAtual, "andou", null, "para o nordeste", tabuleiro);

                case "z":
                    if (lin == 9 || col == 0) {
                        continue;
                    }
                    if (personagemAtual.checaColisao(tabuleiro, lin + 1, col - 1)) {
                        continue;
                    }
                    tabuleiro.tabuleiro[personagemAtual.getPosicao().getLinha()][personagemAtual.getPosicao().getColuna()] = "";
                    personagemAtual.setPosicao(tabuleiro, personagemAtual.getPosicao().getLinha() + 1, personagemAtual.getPosicao().getColuna() - 1);
                    return new Jogada(personagemAtual, "andou", null, "para o sudoeste", tabuleiro);

                case "c":
                    if (lin == 9 || personagemAtual.getPosicao().getColuna() == 9) {
                        continue;
                    }
                    if (personagemAtual.checaColisao(tabuleiro, lin + 1, col + 1)) {
                        continue;
                    }
                    tabuleiro.tabuleiro[personagemAtual.getPosicao().getLinha()][personagemAtual.getPosicao().getColuna()] = "";
                    personagemAtual.setPosicao(tabuleiro, personagemAtual.getPosicao().getLinha() + 1, personagemAtual.getPosicao().getColuna() + 1);
                    return new Jogada(personagemAtual, "andou", null, "para o sudeste", tabuleiro);

                default:
                    break;
            }
        }
        return null;
    }
}
