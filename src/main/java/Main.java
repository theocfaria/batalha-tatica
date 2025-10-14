import entidades.Stark;
import entidades.Tabuleiro;
import utils.Posicao;

public class Main {
    public static void main(String[] args) {
        Stark teste = new Stark();
        teste.setPosicao(new Posicao(4, 0));
        Tabuleiro.imprimirTabuleiro();
    }
}
