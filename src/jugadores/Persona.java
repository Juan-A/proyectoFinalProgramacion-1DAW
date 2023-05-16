package jugadores;

import partida.Tablero;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Persona extends Jugador {

    //Método iniciarPartida que pide el nombre y el color al usuario.
    @Override
    public void iniciarPartida(boolean esPrimerJugador) {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        System.out.print("Introduce tu nombre:");
        nombre = teclado.nextLine();
        this.nombre = nombre;
        if (esPrimerJugador) { //Si es el primer jugador, se le pregunta si quiere elegir color.
            System.out.print("Bien, " + nombre + " quieres elegir color? (S/N): ");
            String respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                System.out.print("Elige color (B/N): ");
                respuesta = teclado.nextLine();
                if (respuesta.equalsIgnoreCase("B")) {
                    this.color = 'B';
                } else {
                    this.color = 'N';
                }
            } else { //Si no quiere elegir color, se le asigna aleatoriamente.
                System.out.println("Color asignado aleatoriamente.");
                this.colorAleatorio();
            }
        } else { //Si es el segundo jugador, se le asigna el color contrario al del primer jugador.
            System.out.println("Color asignado aleatoriamente."); //Se asigna en el constructor de la partida.
        }

    }


    //Recibe un tablero y pide al usuario una posición hasta que sea válida.
    //Devuelve boolean para controlar la salida de la partida.
    @Override
    public boolean ponerFicha(Tablero tablero) {
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
        tablero.imprimirMovimientosValidos(color, true);
        //pedir posicion
        System.out.println("---" + nombre + "---");
        while (!valido) {
            System.out.println("Si deseas salir, introduce 'S'.");
            System.out.print("Introduce una posición (3A p. ej.): ");
            entrada = teclado.nextLine();
            try {
                if (entrada.equalsIgnoreCase("S")) {
                    return true;
                }
                fila = Byte.parseByte(String.valueOf(entrada.charAt(0)));
                fila -= 1;
                columna = Character.toUpperCase(entrada.charAt(1));
                ncolumna = (byte) (columna - 'A');
                //Si es valido salgo del bucle y pongo la ficha en el tablero.
                //Será aquí donde controle errores de formato.
                valido = tablero.esMovimientoValido(fila, ncolumna, color, oponente);
                //Controlo que la fila y columna estén dentro del tablero y  que el formato sea correcto.
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Error, formato incorrecto. Vuelve a intentarlo.");
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Error, formato incorrecto. Vuelve a intentarlo.");
            }
        }
        //Pongo la ficha en el tablero.
        tablero.ponerFicha(fila, ncolumna, color);
        return false;
    }

}
