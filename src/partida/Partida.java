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
    public void imprimirColoresJugadores(){
        if(jugadores[0].getColor()=='B'){
            System.out.println("El jugador 1: fichas blancas.");
            System.out.println("El jugador 2: fichas negras.");
        }else{
            System.out.println("El jugador 1: fichas negras.");
            System.out.println("El jugador 2: fichas blancas.");
        }
    }

    public void pasarRonda(){

    }
    public void mostrarRonda(){

    }
    //mostrarGanador

    //finalizarPartida
    public void finalizarPartida(){

    }
    //contarPuntos

    protected int getRonda() {
        return ronda;
    }

}
