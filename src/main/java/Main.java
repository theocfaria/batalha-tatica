import entidades.Tabuleiro;
import utils.Equipe;
import static utils.LimpadorDeTerminal.limpaTerminal;

public class Main {
    public static void main(String[] args) {
        Tabuleiro campo = new Tabuleiro();
        Equipe equipe1 = new Equipe(1);
        limpaTerminal();
        Equipe equipe2 = new Equipe(2);
        for(int i = 0; (!equipe1.perdeu() || !equipe2.perdeu()); i++){
            if(i % 2 == 0) {
                equipe1.escolheIntegrante();
                Tabuleiro.imprimirTabuleiro();
            }
            else {
                equipe2.escolheIntegrante();
                Tabuleiro.imprimirTabuleiro();
            }
        }
    }
}
