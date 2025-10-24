package replay;

import utils.Personagem;

public class Jogada {

    private int turno;
    private Personagem autor;
    private String acao;
    private Personagem alvo;
    private String resultado;

    public void Jogada(int turno, Personagem autor, String acao, Personagem alvo, String resultado) {

        this.turno = turno;
        this.autor = autor;
        this.acao = acao;
        this.alvo = alvo;
        this.resultado = resultado;

    }

    public String getInfo(){
        if(this.acao == "atacou") {
            return "No " + this.turno + "° turno, " + this.autor.getApresentacao() + " atacou " +
                    this.alvo.getApresentacao() + ", causando " + this.resultado + " de dano.";
        }
        return "No " + this.turno + "° turno, " + this.autor.getApresentacao() + " andou para" + this.resultado;
    }
}
