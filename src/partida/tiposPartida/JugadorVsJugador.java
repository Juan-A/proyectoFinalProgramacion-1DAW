package partida.tiposPartida;

import jugadores.Persona;
import partida.Partida;

import java.util.Random;

public class JugadorVsJugador extends Partida {
    public JugadorVsJugador() {
        super();
        boolean algunoPuedeMover = true, puedeMoverJugador1 = true, puedeMoverJugador2 = true;
        Random generar = new Random();
        byte primerJugador = (byte) generar.nextInt(2);
        byte segundoJugador;
        if (primerJugador == 0) {
            segundoJugador = 1;
        } else {
            segundoJugador = 0;
        }

        jugadores[0] = new Persona();
        jugadores[0].iniciarPartida(true);
        jugadores[1] = new Persona();
        jugadores[1].iniciarPartida(false);
        jugadores[1].setColor(jugadores[0].colorContrarioAdversario());
        imprimirColoresJugadores();

        while (tablero.hayPosicionesLibres() && algunoPuedeMover) {
            if (tablero.puedeMover(jugadores[primerJugador].getColor())) {
                jugadores[primerJugador].ponerFicha(tablero);
                puedeMoverJugador1=true;
            }else{
                puedeMoverJugador1 = false;
            }
            if (tablero.puedeMover(jugadores[segundoJugador].getColor())) {
                jugadores[segundoJugador].ponerFicha(tablero);
                puedeMoverJugador2=true;
            }else{
                puedeMoverJugador2 = false;
            }
            if (tablero.puedeMover(jugadores[primerJugador].getColor()) || tablero.puedeMover(jugadores[segundoJugador].getColor())) {
                algunoPuedeMover = true;
            } else {
                algunoPuedeMover = false;
            }
            ronda++;

        }



    }
}
