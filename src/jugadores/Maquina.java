package jugadores;

import partida.Tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maquina extends Jugador {

    List<int[][]> posicionesValidas = new ArrayList<>();

    public Maquina() {
    }

    public int seleccionarPosicionAleatoria(Tablero tablero) {
        char[][] tableroTemporal = tablero.imprimirMovimientosValidos(color, false);
        for (int i = 0; i < tableroTemporal.length; i++) {
            for (int j = 0; j < tableroTemporal[i].length; j++) {
                if (tableroTemporal[i][j] == '*') {
                    int[][] posicion = new int[1][2];
                    posicion[0][0] = i;
                    posicion[0][1] = j;
                    posicionesValidas.add(posicion);
                }
            }
        }
        Random generar = new Random();
        int posicionAleatoria = generar.nextInt(posicionesValidas.size());
        return posicionAleatoria;
    }

    @Override
    public void ponerFicha(Tablero tablero) {
        System.out.println("---"+nombre+"---");
        tablero.imprimirMovimientosValidos(color,true);

        int posicionAleatoria = seleccionarPosicionAleatoria(tablero);
        byte fila = (byte) posicionesValidas.get(posicionAleatoria)[0][0];
        byte columna = (byte) posicionesValidas.get(posicionAleatoria)[0][1];

        tablero.ponerFicha(fila, columna, color);
        System.out.println("Maquina pone ficha.");

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
