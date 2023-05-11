// -*- coding: utf-8 -*-
import jugadores.Persona;
import partida.Partida;
import partida.Tablero;
import partida.tiposPartida.JugadorVsJugador;
import partida.tiposPartida.JugadorVsMaquina;
import partida.tiposPartida.MaquinaVsMaquina;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // menuIncio();
        /*Persona jugador1 = new Persona();
        jugador1.setColor('N');
        Tablero tablero = new Tablero();
        jugador1.ponerFicha(tablero);
        System.out.println(tablero.toString());
        jugador1.ponerFicha(tablero);
        System.out.println(tablero.toString());
*/
        menuIncio();
    }

    public static void menuIncio() {

        System.out.println(" _____                                       _ ");
        System.out.println(" |  __ \\                                     (_) ");
        System.out.println(" | |__) |   ___  __   __   ___   _ __   ___   _  ");
        System.out.println(" |  _  /   / _ \\ \\ \\ / /  / _ \\ | '__| / __| | | ");
        System.out.println(" | | \\ \\  |  __/  \\ V /  |  __/ | |    \\__ \\ | | ");
        System.out.println(" |_|  \\_\\  \\___|   \\_/    \\___| |_|    |___/ |_| ");
        System.out.println("                                                 ");
        System.out.println("                                                 ");

        boolean salida = false;
        Scanner teclado = new Scanner(System.in);
        while (!salida) {
            System.out.println("-----------------");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            System.out.println("-----------------");

            switch (teclado.nextInt()) {
                case 1:
                    menuJugar();
                    break;
                case 2:
                    System.out.println("Salir");
                    salida = true;
                    break;
            }

        }

    }

    public static void menuJugar() {
        boolean salida = false;
        Scanner teclado = new Scanner(System.in);
        while (!salida) {
            System.out.println("-----------------");

            System.out.println("Seleccione modalidad: ");
            System.out.println("1.Jugador vs Jugador");
            System.out.println("2.Jugador vs Ordenador");
            System.out.println("3.Ordenador vs Ordenador");
            System.out.println("4.Salir");
            switch (teclado.nextInt()) {
                case 1:
                    System.out.println("Jugador vs Jugador");
                    Partida partida1 = new JugadorVsJugador();
                    break;
                case 2:
                    System.out.println("Jugador vs Ordenador");
                    Partida partida = new JugadorVsMaquina();
                    break;
                case 3:
                    System.out.println("Ordenador vs Ordenador");
                    Partida partida3 = new MaquinaVsMaquina();
                    break;
                case 4:
                    System.out.println("Salir");
                    break;
            }
        }
    }

}