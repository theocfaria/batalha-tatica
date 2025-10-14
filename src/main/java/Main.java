import utils.Equipe;
import entidades.Tabuleiro;

public class Main {

    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();

        System.out.println("--- Configuração da Equipe 1 ---");
        Equipe equipe1 = new Equipe(1);

        System.out.println("\n--- Configuração da Equipe 2 ---");
        Equipe equipe2 = new Equipe(2);

        for (int turno = 0; !equipe1.perdeu() && !equipe2.perdeu(); turno++) {
            Tabuleiro.imprimirTabuleiro();

            if (turno % 2 == 0) {
                System.out.println("\n--- TURNO DA EQUIPE 1 ---");
                equipe1.escolheIntegrante(equipe2);
            } else {
                System.out.println("\n--- TURNO DA EQUIPE 2 ---");
                equipe2.escolheIntegrante(equipe1);
            }
        }

        Tabuleiro.imprimirTabuleiro();
        if (equipe1.perdeu()) {
            System.out.println("A EQUIPE 2 VENCEU!");
        } else {
            System.out.println("A EQUIPE 1 VENCEU!");
        }
    }
}