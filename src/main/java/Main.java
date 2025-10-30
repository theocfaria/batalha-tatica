import entidades.Bot;
import replay.Jogada;
import replay.Replay;
import utils.Equipe;
import entidades.Tabuleiro;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        Equipe equipe1, equipe2;

        Replay replay = new Replay();
        Jogada jogadaAtual, preJogo;

        System.out.println("Você deseja jogar com um amigo ou com o computador? Digite 1 para jogar com amigos, qualquer outra coisa pra jogar com o computador.");
        String opcao = sc.nextLine();
        if(opcao.equals("1")) {
            System.out.println("--- Configuração da Equipe 1 ---");
            equipe1 = new Equipe(tabuleiro, 1);

            System.out.println("\n--- Configuração da Equipe 2 ---");
            equipe2 = new Equipe(tabuleiro, 2);
        }
        else {
            System.out.println("--- Configuração da Equipe 1 ---");
            equipe1 = new Equipe(tabuleiro, 1);

            equipe2 = new Equipe(tabuleiro, 3);
        }

        preJogo = new Jogada(tabuleiro);
        preJogo.setTurno(0);
        replay.adicionaTurno(preJogo);

        for (int turno = 1; !equipe1.perdeu() && !equipe2.perdeu(); turno++) {
            tabuleiro.imprimirTabuleiro();
            if (turno % 2 != 0) {
                System.out.println("\n--- TURNO DA EQUIPE 1 ---");
                int escolhido = equipe1.escolheIntegrante();
                jogadaAtual = equipe1.getPersonagem(escolhido).agir(tabuleiro, equipe2);
            } else {
                System.out.println("\n--- TURNO DA EQUIPE 2 ---");
                if(equipe2.getId() == 3){
                    jogadaAtual = Bot.joga(tabuleiro, equipe2, equipe1);
                }
                else {
                    int escolhido = equipe2.escolheIntegrante();
                    jogadaAtual = equipe2.getPersonagem(escolhido).agir(tabuleiro, equipe1);
                }
            }
            jogadaAtual.setTurno(turno);
            replay.adicionaTurno(jogadaAtual);
        }

        if (equipe1.perdeu()) {
            System.out.println("A EQUIPE 2 VENCEU!");
        } else {
            System.out.println("A EQUIPE 1 VENCEU!");
        }

        System.out.println("\n--- FIM DE JOGO ---");
        System.out.println("Deseja ver o replay? (s/n)");
        String resposta = sc.next();

        if (resposta.toLowerCase().equals("s")){
            System.out.println("\n--- INICIANDO REPLAY ---");
            replay.controleReplay();
        }

        System.out.print("Encerrando o programa");
        Thread.sleep(600);
        System.out.print(".");
        Thread.sleep(600);
        System.out.print(".");
        Thread.sleep(600);
        System.out.print(".");
        Thread.sleep(300);
        sc.close();
    }
}