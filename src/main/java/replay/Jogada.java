package replay;

import utils.Equipe;
import utils.Personagem;

public class Jogada {

    private int turno;
    private Personagem autor;
    private String acao;
    private Personagem alvo;
    private String resultado;

    public Jogada(int turno, Personagem autor, String acao, Personagem alvo, String resultado) {

        this.turno = turno;
        this.autor = autor;
        this.acao = acao;
        this.alvo = alvo;
        this.resultado = resultado;

    }

    public String getInfo(){
        if("atacou".equals(this.acao) && this.alvo != null) {
            return "No " + this.turno + "° turno, " + this.autor.getApresentacao() + " atacou " +
                    this.alvo.getApresentacao() + ", causando " + this.resultado + " de dano.";
        }
        return "No " + this.turno + "° turno, " + this.autor.getApresentacao() + " andou " + this.resultado;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getTurno() {
        return turno;
    }

    public Personagem getAutor() {
        return autor;
    }

    public String getAcao() {
        return acao;
    }

    public Personagem getAlvo() {
        return alvo;
    }

    public String getResultado() {
        return resultado;
    }
}

