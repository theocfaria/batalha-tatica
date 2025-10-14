package utils;

public class LimpadorDeTerminal {
    public static void limpaTerminal(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
