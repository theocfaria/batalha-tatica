package utils;

public class Tabuleiro {
    public String[][] tabuleiro;

    public Tabuleiro() {
        tabuleiro = new String[10][10];

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                tabuleiro[i][j] = " ";
            }
        }
    }
}
