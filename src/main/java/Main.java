import replay.Jogada;
import replay.Replay;
import utils.Equipe;
import entidades.Tabuleiro;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Tabuleiro tabuleiro = new Tabuleiro();

        Replay replay = new Replay();
        Jogada jogadaAtual;
        int contaTurno = 0;

        System.out.println("--- Configuração da Equipe 1 ---");
        Equipe equipe1 = new Equipe(1);

        System.out.println("\n--- Configuração da Equipe 2 ---");
        Equipe equipe2 = new Equipe(2);

        for (int turno = 0; !equipe1.perdeu() && !equipe2.perdeu() && turno < 5; turno++) {
            if (turno % 2 == 0) {
                System.out.println("\n--- TURNO DA EQUIPE 1 ---");
                jogadaAtual = equipe1.escolheIntegrante(equipe2);
            } else {
                System.out.println("\n--- TURNO DA EQUIPE 2 ---");
                jogadaAtual= equipe2.escolheIntegrante(equipe1);
            }
            contaTurno++;
            jogadaAtual.setTurno(contaTurno);
            replay.adicionaTurno(contaTurno, jogadaAtual);
        }

        if (equipe1.perdeu()) {
            System.out.println("A EQUIPE 2 VENCEU!");
        } else {
            System.out.println("A EQUIPE 1 VENCEU!");
        }

        System.out.println("\n--- FIM DE JOGO ---");
        System.out.println("Deseja ver o replay? (s/n)");
        Scanner sc = new Scanner(System.in);
        String resposta = sc.next();

        if (resposta.toLowerCase().equals("s")){
            System.out.println("\n--- INICIANDO REPLAY ---");
            replay.controleReplay();
        }

        System.out.println("Encerrando o programa.");
        sc.close();
    }
}