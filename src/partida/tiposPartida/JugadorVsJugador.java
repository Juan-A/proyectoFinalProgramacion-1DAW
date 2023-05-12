package partida.tiposPartida;

import jugadores.Persona;
import partida.Partida;

import java.util.Random;

public class JugadorVsJugador extends Partida {
    public JugadorVsJugador() {
        super();
        boolean algunoPuedeMover = true, puedeMoverJugador1 = true, puedeMoverJugador2 = true;


        jugadores[0] = new Persona();
        jugadores[0].iniciarPartida(true);
        jugadores[1] = new Persona();
        jugadores[1].iniciarPartida(false);
        jugadores[1].setColor(jugadores[0].colorContrarioAdversario());
        imprimirColoresJugadores();

        jugadas();



    }
}
