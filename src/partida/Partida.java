package partida;

import jugadores.Jugador;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Partida {
    protected Tablero tablero;
    protected int ronda;
    protected Jugador[] jugadores = new Jugador[2];

    //Inicio los valores del tablero, los puntos y las rondas.
    public Partida() {
        this.tablero = new Tablero();
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
        Map<Character,Jugador> jugadorTemp = new HashMap<Character,Jugador>();
        if(jugadores[0].getColor() == 'B') {
            jugadorTemp.put('B', jugadores[0]);
            jugadorTemp.put('N', jugadores[1]);
        } else {
            jugadorTemp.put('B', jugadores[1]);
            jugadorTemp.put('N', jugadores[0]);
        }
        StringBuilder ganador = new StringBuilder();
        int fichasblancas = 0, fichasnegras = 0;
        for (int i = 0; i < tablero.getTablero().length; i++) {
            for (int j = 0; j < tablero.getTablero()[i].length; j++) {
                if (tablero.getTablero()[i][j] == 'B') {
                    fichasblancas++;
                } else if (tablero.getTablero()[i][j] == 'N') {
                    fichasnegras++;
                }
            }
        }
        if (fichasblancas > fichasnegras) {
            ganador.append(jugadorTemp.get('B'));
        } else if (fichasblancas < fichasnegras) {
            ganador.append(jugadorTemp.get('N'));
        } else if (fichasblancas == fichasnegras) {
            ganador.append("Empate! No hay ganador.");
        }
        System.out.println("----Resumen del juego----");
        ganador.append(" Con " + fichasblancas + " fichas blancas y " + fichasnegras + " fichas negras.");
        ganador.append("\n En " + ronda + " rondas.");
        System.out.println("El ganador es: " + ganador);
        System.out.println("-------------------------");

    }

    //Este método lleva a cabo el proceso de partida a partir de dos jugadores creados previamente.
    //Pide la colocación de fichas y sigue la partida mientras sea posible.
    public void jugadas() {
        boolean algunoPuedeMover = true, puedeMoverJugador1 = true, puedeMoverJugador2 = true, terminar = false;
        //El booleano "terminar" sirve para pasar el fin de partida a este método.
        boolean ambosMaquina = jugadores[0] instanceof jugadores.Maquina && jugadores[1] instanceof jugadores.Maquina;
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
                puedeMoverJugador1 = true;
            } else {
                System.out.println("El jugador " + jugadores[primerJugador] + " no puede mover.");
                puedeMoverJugador1 = false;
            }

            if (tablero.puedeMover(jugadores[segundoJugador].getColor()) && !terminar) {
                terminar = jugadores[segundoJugador].ponerFicha(tablero);
                puedeMoverJugador2 = true;
            } else {
                System.out.println("El jugador " + jugadores[segundoJugador] + " no puede mover.");
                puedeMoverJugador2 = false;
            }
            if(ambosMaquina){
                //Si ambos son máquina, se espera un poco para que se vea el movimiento.
                System.out.println("Pulse enter para continuar.");
                Scanner teclado = new Scanner(System.in);
                teclado.nextLine();
            }
            algunoPuedeMover = tablero.puedeMover(jugadores[primerJugador].getColor()) || tablero.puedeMover(jugadores[segundoJugador].getColor());
            ronda++;

        }
        System.out.println("Tablero final:\n"+tablero);

    }

}
