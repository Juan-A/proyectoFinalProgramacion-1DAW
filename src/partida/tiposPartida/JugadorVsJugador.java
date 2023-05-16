package partida.tiposPartida;

import jugadores.Persona;
import partida.Partida;


public class JugadorVsJugador extends Partida {
    public JugadorVsJugador() {
        super();

        jugadores[0] = new Persona();
        jugadores[0].iniciarPartida(true);
        jugadores[1] = new Persona();
        jugadores[1].iniciarPartida(false);
        jugadores[1].setColor(jugadores[0].colorContrarioAdversario());
        imprimirColoresJugadores();

        jugadas();


    }
}
