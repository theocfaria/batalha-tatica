package entidades;

import java.io.IOException;

public class Tabuleiro {
    public static String[][] tabuleiro;
    public static final int TAMANHO = 10;
    private static final int LARGURA_CELULA = 5;

    public Tabuleiro() {
        tabuleiro = new String[10][10];

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                tabuleiro[i][j] = "";
            }
        }
    }

    public static void imprimirTabuleiro() {
        desenharLinhaSeparadora('┌', '┬', '┐');

        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print("│");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                String conteudo = tabuleiro[i][j];
                System.out.print(centralizarTexto(conteudo, LARGURA_CELULA));
                System.out.print("│");
            }

            System.out.println();
            if (i < tabuleiro.length - 1) {
                desenharLinhaSeparadora('├', '┼', '┤');
            } else {
                desenharLinhaSeparadora('└', '┴', '┘');
            }
        }
    }

    private static void desenharLinhaSeparadora(char esq, char meio, char dir) {
        System.out.print(esq);
        for (int j = 0; j < TAMANHO; j++) {
            System.out.print("─".repeat(LARGURA_CELULA));
            if (j < TAMANHO - 1) {
                System.out.print(meio);
            }
        }
        System.out.println(dir);
    }

    private static int getLarguraVisual(String texto) {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }
        int largura = 0;
        for (int codePoint : texto.codePoints().toArray()) {
            Character.UnicodeBlock bloco = Character.UnicodeBlock.of(codePoint);
            if (bloco != null && (
                    bloco == Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS ||
                            bloco == Character.UnicodeBlock.EMOTICONS ||
                            bloco == Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_ARROWS
            )) {
                largura += 2;
            } else {
                largura += 1;
            }
        }
        return largura;
    }


    private static String centralizarTexto(String texto, int largura) {
        if (texto == null) {
            texto = "";
        }

        int larguraVisual = getLarguraVisual(texto);

        if (larguraVisual > largura) {
            return texto;
        }

        int espacosTotal = largura - larguraVisual;
        int padEsquerda = espacosTotal / 2;
        int padDireita = espacosTotal - padEsquerda;

        return " ".repeat(padEsquerda) + texto + " ".repeat(padDireita);
    }
}
