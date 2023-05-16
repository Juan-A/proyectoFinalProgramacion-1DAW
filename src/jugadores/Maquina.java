package jugadores;

import partida.Tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maquina extends Jugador {
//Almacena en una lista los pares de posiciones válidas para la máquina.
    List<int[][]> posicionesValidas = new ArrayList<>();

    public Maquina() {
    }

    //Método que selecciona una posición aleatoria de la lista de posiciones válidas.
    public int seleccionarPosicionAleatoria(Tablero tablero) {
        char[][] tableroTemporal = tablero.imprimirMovimientosValidos(color, false);
        //Recorro el tablero
        for (int i = 0; i < tableroTemporal.length; i++) {
            for (int j = 0; j < tableroTemporal[i].length; j++) {
                //Si me encuentro con una posicion valida, la registro en la lista
                if (tableroTemporal[i][j] == '*') {
                    int[][] posicion = new int[1][2];
                    posicion[0][0] = i;
                    posicion[0][1] = j;
                    posicionesValidas.add(posicion);
                }
            }
        }
        Random generar = new Random();
        //Genero un número aleatorio entre 0 y el tamaño de la lista de posiciones válidas
        //Devuelvo la posición aleatoria
        return generar.nextInt(posicionesValidas.size());
    }

    //Método que pone la ficha en el tablero.
    //Boolean controla la salida voluntaria para personas, para maquina es un apano.
    @Override
    public boolean ponerFicha(Tablero tablero) {
        System.out.println("---"+nombre+"---");
        tablero.imprimirMovimientosValidos(color,true);
        //Selecciono posicion aleatoria
        int posicionAleatoria = seleccionarPosicionAleatoria(tablero);
        //Con el numero aleatorio (posicion en la lista), obtengo la fila y columna de la posicion.
        byte fila = (byte) posicionesValidas.get(posicionAleatoria)[0][0];
        byte columna = (byte) posicionesValidas.get(posicionAleatoria)[0][1];

        //Pongo la ficha en el tablero
        tablero.ponerFicha(fila, columna, color);
        System.out.println("Maquina pone ficha.");
        return false;
    }
    public void iniciarPartida(boolean esPrimerJugador){
        //El color de maquina lo inicio después de que el usuario elija el suyo
        if(esPrimerJugador){
            nombre = "Maquina";
        }else{
            nombre = "Maquina 2";
        }
    }
}
