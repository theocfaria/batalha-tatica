package replay;

import utils.Tabuleiro;
import entidades.Personagem;

public class Jogada {
    private int turno = 0;
    private Personagem autor;
    private String acao;
    private Personagem alvo;
    private String resultado;
    protected String[][] tabuleiro;

    public Jogada(Personagem autor, String acao, Personagem alvo, String resultado, Tabuleiro tabuleiro) {
        this.tabuleiro = copiaTabuleiro(tabuleiro);
        this.autor = autor;
        this.acao = acao;
        this.alvo = alvo;
        this.resultado = resultado;
    }

    public Jogada(Tabuleiro tabuleiro) {
        this.tabuleiro = copiaTabuleiro(tabuleiro);
    }

    private String[][] copiaTabuleiro(Tabuleiro tabuleiro) {
        int linhas = tabuleiro.getTabuleiro().length;
        int colunas = tabuleiro.getTabuleiro()[0].length;
        String[][] copia = new String[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            copia[i] = tabuleiro.getTabuleiro()[i].clone();
        }

        return copia;
    }

    public String getInfo() {
        if(this.turno == 0){
            return "";
        }
        if("atacou".equals(this.acao) && this.alvo != null) {
            return "No " + this.turno + "° turno, " + this.autor.getApresentacao() + " atacou " +
                    this.alvo.getApresentacao() + ", causando " + this.resultado + " de dano.";
        }
        return "No " + this.turno + "° turno, " + this.autor.getApresentacao() + " andou " + this.resultado;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}

