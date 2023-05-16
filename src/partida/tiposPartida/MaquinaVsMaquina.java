package partida.tiposPartida;

import jugadores.Maquina;
import partida.Partida;

import java.util.Random;

public class MaquinaVsMaquina extends Partida {
    public MaquinaVsMaquina() {
        super();
        Random generar = new Random();
        byte primerJugador = (byte) generar.nextInt(2);
        byte segundoJugador;
        if (primerJugador == 0) {
            segundoJugador = 1;
        } else {
            segundoJugador = 0;
        }

        jugadores[primerJugador] = new Maquina();
        jugadores[primerJugador].iniciarPartida(true);
        jugadores[primerJugador].colorAleatorio();
        jugadores[segundoJugador] = new Maquina();
        jugadores[segundoJugador].iniciarPartida(false);
        jugadores[segundoJugador].setColor(jugadores[0].colorContrarioAdversario());


        jugadas();
    }
}
