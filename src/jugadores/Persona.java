package jugadores;

import partida.Partida;
import partida.Tablero;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Persona extends Jugador {
    @Override
    public void iniciarPartida(boolean esPrimerJugador) {
        Random generar = new Random();
        int colorAleatorio;
        Scanner teclado = new Scanner(System.in);
        String nombre;
        System.out.print("Introduce tu nombre:");
        nombre = teclado.nextLine();
        this.nombre = nombre;
        if(esPrimerJugador){
            System.out.println("Bien, " + nombre + " quieres elegir color? (S/N):");
            String respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                System.out.println("Elige color (B/N):");
                respuesta = teclado.nextLine();
                if (respuesta.equalsIgnoreCase("B")) {
                    this.color = 'B';
                } else {
                    this.color = 'N';
                }
            } else {
                System.out.println("Color asignado aleatoriamente.");
                this.colorAleatorio();
            }
        }else{
            System.out.println("Color asignado aleatoriamente."); //Se asigna en el constructor de la partida.
        }

    }

    public void abandonar() {

    }

    @Override
    public void ponerFicha(Tablero tablero) {
        Scanner teclado = new Scanner(System.in);
        byte fila = 0, ncolumna = 0;
        char columna, oponente;
        String entrada;
        boolean valido = false;
        if (color == 'B') {
            oponente = 'N';
        } else {
            oponente = 'B';
        }
//mostrar tablero:
        tablero.imprimirMovimientosValidos(color,true);
        //pedir posicion
        System.out.println("---" + nombre + "---");
        while (!valido) {
            System.out.print("Introduce una posición (3A p. ej.):");
            entrada = teclado.nextLine();
            try {
                fila = Byte.parseByte(String.valueOf(entrada.charAt(0)));
                fila -= 1;
                columna = Character.toUpperCase(entrada.charAt(1));
                ncolumna = (byte) (columna - 'A');
                valido = tablero.esMovimientoValido(fila, ncolumna, color, oponente);
            } catch (InputMismatchException e) {
                System.out.println("Error, formato incorrecto. Vuelve a intentarlo.");
            } catch (NumberFormatException e) {
                System.out.println("Error, formato incorrecto. Vuelve a intentarlo.");
            }

            //comprobar posicion

            //poner ficha
            //comprobar si hay ganador (pos vacias)
            //comprobar si hay empate (pos vacias)
            //cambiar turno
        }
        tablero.ponerFicha(fila, ncolumna, color);
    }
    public void crearJugador(){

    }
}
