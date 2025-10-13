package entidades;

import utils.Posicionamento;

public class Stark extends Personagem {
    public Stark(Posicionamento posicao) {
        this.vidaMaxima = 60.0;
        this.ataqueBase = 20.0;
        this.defesaBase = 10.0;
        this.alcance = 1;
        this.posicao = posicao;
    }
}
