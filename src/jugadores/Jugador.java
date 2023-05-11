package jugadores;

import partida.Tablero;

import java.util.Random;

public abstract class Jugador {
    String nombre;
    char color;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public void colorAleatorio() {
        Random generar = new Random();
        if (generar.nextInt(2) == 0) {
            this.color = 'N';
        } else {
            this.color = 'B';
        }

    }
    public String colorToString(){
        if (this.color=='N'){
            return "Negras";
        }else{
            return "Blancas";
        }
    }

    //public void moverFicha
    public abstract void ponerFicha(Tablero tablero);

    public abstract void iniciarPartida(boolean primerJugador);

    public char colorContrarioAdversario() {
        if (this.color == 'N') {
            return 'B';
        } else {
            return 'N';
        }
    }

}
