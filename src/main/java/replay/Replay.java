package replay;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Replay {

    public Map<Integer, Jogada> turnos = new HashMap<>();
    private int turnoAtual = 0;

    public void controleReplay(){

        Scanner teclado = new Scanner(System.in);

        while(true) {
            System.out.println("-- Menu de Replay --");
            System.out.println("Turno atual: " + turnoAtual);
            System.out.println("1 - Ver turno anterior");
            System.out.println("2 - Ver próximo turno");
            System.out.println("3 - Encerrar replay");
            System.out.println("Selecione a próxima ação: ");

            int acao = 0;

            try{
                acao = teclado.nextInt();
            } catch(Exception e){
                System.out.println("Entrada inválida.");
                teclado.next();
                continue;
            }

            if(acao < 1 || acao > 3){
                System.out.println("Ação inválida, selecione novamente...");
                continue;
            }

            switch (acao){
                case 1:
                    voltarTurno();
                    break;
                case 2:
                    passarTurno();
                    break;
                case 3:
                    return;
            }
        }
    }

    public void adicionaTurno(int contagemTurno, Jogada rodadaAtual){
        this.turnos.put(contagemTurno, rodadaAtual);
    }

    private void passarTurno() {
        if (this.turnoAtual >= turnos.size()) {
            System.out.println(">> Fim do replay. Não há próximos turnos.");
            return;
        }
        this.turnoAtual++;
        Jogada j = turnos.get(this.turnoAtual);
        System.out.println(">> " + j.getInfo());
    }

    private void voltarTurno() {
        if (this.turnoAtual <= 1) {
            System.out.println(">> Início do replay. Não há turnos anteriores.");
            return;
        }
        this.turnoAtual--;
        Jogada j = turnos.get(this.turnoAtual);
        System.out.println(">> " + j.getInfo());
    }

}
