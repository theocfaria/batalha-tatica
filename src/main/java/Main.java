import entidades.Stark;
import entidades.Tabuleiro;
import entidades.Lannister;
import entidades.Targaryen;
import utils.Equipe;

public class Main {
    public static void main(String[] args) {
        Tabuleiro campo = new Tabuleiro();
        Equipe equipe = new Equipe();
        Stark teste = new Stark(equipe);
        Targaryen teste2 = new Targaryen(equipe);
//        teste.setPosicao(4, 0);
        teste2.setPosicao(4, 1);
//        teste2.printStatus();
//        teste.atacar(teste2);
//        teste2.printStatus();
        while(true) {
            Tabuleiro.imprimirTabuleiro();
            teste2.agir();
        }
    }
}
