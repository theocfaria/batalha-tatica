import entidades.Stark;
import entidades.Tabuleiro;
import utils.Posicao;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Tabuleiro campo = new Tabuleiro();
        Stark teste = new Stark();
        teste.setPosicao(4, 0);
        while(true) {
            Tabuleiro.imprimirTabuleiro();
            teste.andar();
        }
    }
}
