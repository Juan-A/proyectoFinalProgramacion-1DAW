package jugadores;

import partida.Tablero;

import java.util.Random;

public abstract class Jugador {
    String nombre;
    char color;

    public char getColor() {
        return color;
    } //Devuelve B o N

    //Recibe B o N y lo asigna
    public void setColor(char color) {
        this.color = color;
    }

    //Establece un color aleatorio.
    public void colorAleatorio() {
        Random generar = new Random();
        if (generar.nextInt(2) == 0) {
            this.color = 'N';
        } else {
            this.color = 'B';
        }

    }

    //Devuelve el color B o N de forma más legible.
    public String colorToString() {
        if (this.color == 'N') {
            return "Negras";
        } else {
            return "Blancas";
        }
    }

    //Método abstracto diferente para Maquina y Persona
    public abstract boolean ponerFicha(Tablero tablero);

    //Método abstracto que inicia el jugador (Persona o Maquina)
    public abstract void iniciarPartida(boolean primerJugador);

    //Devuelve el color contrario al del jugador.
    public char colorContrarioAdversario() {
        if (this.color == 'N') {
            return 'B';
        } else {
            return 'N';
        }
    }

    @Override
    public String toString() {
        return nombre + " con las fichas " + colorToString() + ".";
    }
}
