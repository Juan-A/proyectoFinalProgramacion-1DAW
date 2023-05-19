package partida.tiposPartida;

import jugadores.Maquina;
import jugadores.Persona;
import partida.Partida;

import java.util.Random;

public class JugadorVsMaquina extends Partida {
    public JugadorVsMaquina() {
        super();
        Random generar = new Random();
        byte primerJugador = (byte) generar.nextInt(2);
        byte segundoJugador;
        if (primerJugador == 0) {
            segundoJugador = 1;
        } else {
            segundoJugador = 0;
        }

        jugadores[primerJugador] = new Persona();
        jugadores[primerJugador].iniciarPartida(true);
        jugadores[segundoJugador] = new Maquina();
        jugadores[segundoJugador].iniciarPartida(false);
        jugadores[segundoJugador].setColor(jugadores[0].colorContrarioAdversario());
        imprimirColoresJugadores();

        jugadas();


    }
}
