package partida.tiposPartida;

import jugadores.Maquina;
import partida.Partida;

import java.util.Random;

public class MaquinaVsMaquina extends Partida {
    public MaquinaVsMaquina() {
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

        jugadores[0] = new Maquina();
        jugadores[0].iniciarPartida(true);
        jugadores[0].colorAleatorio();
        jugadores[1] = new Maquina();
        jugadores[1].iniciarPartida(false);
        jugadores[1].setColor(jugadores[0].colorContrarioAdversario());


        jugadas();
    }
}
