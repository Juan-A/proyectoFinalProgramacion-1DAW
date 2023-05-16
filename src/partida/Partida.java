package partida;

import jugadores.Jugador;

import java.util.Random;

public class Partida {
    protected Tablero tablero;
    private int punto;
    protected int ronda;
    protected Jugador[] jugadores = new Jugador[2];

    //Inicio los valores del tablero, los puntos y las rondas.
    public Partida() {
        this.tablero = new Tablero();
        this.punto = 0;
        this.ronda = 0;

    }

    //Imprime los colores de los jugadores.
    public void imprimirColoresJugadores() {
        if (jugadores[0].getColor() == 'B') {
            System.out.println("El jugador 1: fichas blancas.");
            System.out.println("El jugador 2: fichas negras.");
        } else {
            System.out.println("El jugador 1: fichas negras.");
            System.out.println("El jugador 2: fichas blancas.");
        }
    }

    //Aquí iba la función "pasarRonda", que finalmente no se implementará porque se ejecuta directamente en la mod. de juego.
    //mostrarRonda
    public void mostrarRonda() {
        System.out.println("Ronda: " + ronda);
    }
    //mostrarGanador
    public void mostrarGanador() {
        StringBuilder ganador = new StringBuilder();
        int fichasblancas = 0, fichasnegras = 0;
        for (int i = 0; i < tablero.getTablero().length; i++) {
            for (int j = 0; j < tablero.getTablero()[i].length; j++) {
                if (tablero.getTablero()[i][j] == 'B') {
                    fichasblancas++;
                } else if (tablero.getTablero()[i][j] == 'N'){
                    fichasnegras++;
                }
            }
        }
        if (fichasblancas > fichasnegras) {
            ganador.append(jugadores[0].toString());
        } else if (fichasblancas < fichasnegras) {
            ganador.append(jugadores[1].toString());
        } else if (fichasblancas == fichasnegras) {
            ganador.append("Empate! No hay ganador.");
        }
        ganador.append(" con "+fichasblancas+" fichas blancas y "+fichasnegras+" fichas negras.");
        System.out.println("El ganador es: " + ganador.toString());

    }
    public void jugadas(){
        boolean algunoPuedeMover = true, puedeMoverJugador1 = true, puedeMoverJugador2 = true, terminar = false;
        Random generar = new Random();
        byte primerJugador = (byte) generar.nextInt(2);
        byte segundoJugador;
        if (primerJugador == 0) {
            segundoJugador = 1;
        } else {
            segundoJugador = 0;
        }
        while (!terminar && tablero.hayPosicionesLibres() && algunoPuedeMover) {
            System.out.println("--------------------");
            mostrarRonda();
            if (tablero.puedeMover(jugadores[primerJugador].getColor())) {
                terminar = jugadores[primerJugador].ponerFicha(tablero);
                puedeMoverJugador1=true;
            }else{
                System.out.println("El jugador "+jugadores[primerJugador].getColor()+" no puede mover.");
                puedeMoverJugador1 = false;
            }
            if (tablero.puedeMover(jugadores[segundoJugador].getColor()) && !terminar) {
                terminar = jugadores[segundoJugador].ponerFicha(tablero);
                puedeMoverJugador2=true;
            }else{
                System.out.println("El jugador "+jugadores[segundoJugador].getColor()+" no puede mover.");
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


    //finalizarPartida
    public void finalizarPartida() {

    }

    protected int getRonda() {
        return ronda;
    }

}
