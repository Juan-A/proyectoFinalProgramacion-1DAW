package partida;

import jugadores.Jugador;

public class Partida {
    protected Tablero tablero;
    private int punto;
    protected int ronda;
    protected Jugador[] jugadores = new Jugador[2];

    public Partida() {
        this.tablero = new Tablero();
        this.punto = 0;
        this.ronda = 0;

    }

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
    //mostrarRonda?
    //mostrarGanador
    public void mostrarGanador() {
        StringBuilder ganador = new StringBuilder();
        int fichasblancas = 0, fichasnegras = 0;
        for (int i = 0; i < tablero.getTablero().length; i++) {
            for (int j = 0; j < tablero.getTablero()[i].length; j++) {
                if (tablero.getTablero()[i][j] == 'B') {
                    fichasblancas++;
                } else {
                    fichasnegras++;
                }
            }
        }
        if (fichasblancas > fichasnegras) {
            ganador.append(jugadores[0].toString());
        } else if (fichasblancas < fichasnegras) {
            ganador.append(jugadores[1].toString());
        }
        System.out.println("El ganador es: " + ganador.toString());

    }


    //finalizarPartida
    public void finalizarPartida() {

    }
    //contarPuntos

    protected int getRonda() {
        return ronda;
    }

}
