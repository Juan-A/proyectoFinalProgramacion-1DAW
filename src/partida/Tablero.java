package partida;

import java.util.Random;

public class Tablero {
    private static final char FICHA_BLANCA = '○';
    private static final char FICHA_NEGRA = '●';
    private static final char FICHA_VACIA = '□';
    private static final String FORMATO_TABLERO = "\u001B[47m" + "\u001B[30m"; //Define color de fondo y de fuente, respectivamente.
    private static final String FORMATO_RESTAURAR = "\u001B[0m"; //Resetea el formato.

    char[][] tablero = new char[8][8];

    public char[][] getTablero() {
        return tablero;
    }

    public Tablero() {
        int numBlancas = 2;
        int numNegras = 2;
        char blanca = 'B';
        char negra = 'N';
        Random generar = new Random();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = 'V'; //Posiciones vacias.
            }
        }
        //Rellena el tablero con 2 fichas negras y 2 blancas en el centro de la matriz, de forma aleatoria.
        for (int i = 3; i <= 4; i++) {
            for (int j = 3; j <= 4; j++) {
                int random = generar.nextInt(2);

                if (random == 0 && numBlancas > 0) { //Si el random es 0 y quedan fichas blancas por colocar, coloca una ficha blanca.
                    tablero[i][j] = blanca; //ASCII CIRC. BLANCO
                    numBlancas--;
                } else if (random == 1 && numNegras > 0) { //Si el random es 1 y quedan fichas negras por colocar, coloca una ficha negra.
                    tablero[i][j] = negra; //ASCII CIRC. NEGRO
                    numNegras--;
                } else if (numNegras > 0) { //Si siguen quedando fichas y se han agotado las anteriores opciones...
                    tablero[i][j] = negra; //ASCII CIRC. NEGRA
                    numNegras--;
                } else if (numBlancas > 0) {
                    tablero[i][j] = blanca; //ASCII CIRC. BLANCA
                    numBlancas--;

                }

            }
        }
    }

    public boolean esMovimientoValido(int x, int y, char jugador, char adversario) {

        // Verificar que la posición esté vacía y no introduzco posicion fuera del tablero
        if (x >= 8 || y >= 8 || x < 0 || y < 0 || tablero[x][y] != 'V') {
            return false;
        }

        // Verificar que haya al menos una ficha del adversario en una dirección
        boolean fichaAdversarioEncontrada = false;
        //Esta sería una forma diferente a la que tenemos en ponerFicha de comprobar las dif. direcciones.
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                // Si no me muevo en ninguna dirección o me salgo del tablero, paso a la siguiente iteración
                if (dx == 0 && dy == 0 || x + dx < 0 || x + dx >= 8 || y + dy < 0 || y + dy >= 8) {
                    continue; //Esto hace que se salte la iteracion actual y pase a la siguiente del bucle.
                }

                // Encontrar la primera ficha del adversario en la dirección
                int distanciaFichaAdv = 1;
                while (x + distanciaFichaAdv * dx >= 0 && x + distanciaFichaAdv * dx < 8 && y + distanciaFichaAdv * dy >= 0 && y + distanciaFichaAdv * dy < 8 && tablero[x + distanciaFichaAdv * dx][y + distanciaFichaAdv * dy] == adversario) {
                    distanciaFichaAdv++;
                }

                // Verificar que haya al menos una ficha del jugador después de la ficha del adversario
                if (x + distanciaFichaAdv * dx >= 0 && x + distanciaFichaAdv * dx < 8 && y + distanciaFichaAdv * dy >= 0 && y + distanciaFichaAdv * dy < 8 && tablero[x + distanciaFichaAdv * dx][y + distanciaFichaAdv * dy] == jugador && distanciaFichaAdv > 1) {
                    fichaAdversarioEncontrada = true;
                    break; //sale del bucle for anidado.
                }
            }
        }

        return fichaAdversarioEncontrada;
    }

    public boolean hayPosicionesLibres() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 'V') { //Si encuentra alguna posicion vacia, devuelve directamente true
                    return true;
                }
            }
        }
        return false;//Si no encuentra, devuelve false.

    }

    public boolean puedeMover(char color) {

        if (hayPosicionesLibres()) {
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    if (esMovimientoValido(i, j, color, (color == 'B') ? 'N' : 'B')) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void ponerFicha(byte x, byte y, char color) {
        tablero[x][y] = color;

        // Cambiar el color de las fichas capturadas en cada dirección
        char adversario = (color == 'B') ? 'N' : 'B';
        int[][] direcciones = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] direccion : direcciones) {
            int direccionX = direccion[0];
            int direccionY = direccion[1];

            // Distancia a la que se encuentra la ficha del adversario
            int distanciaFichaAdv = 1;
            //Cada una de esas condiciones se asegura de que no me salgo del tablero.
            //La condición tablero [x + i*direccionX][y + i*direccionY] == adversario se asegura de que la ficha sea del adversario.
            //Si no me salgo del tablero, y la ficha es del adversario, incremento distanciaFichaAdv.
            while (x + distanciaFichaAdv * direccionX >= 0 && x + distanciaFichaAdv * direccionX < 8 && y + distanciaFichaAdv * direccionY >= 0 && y + distanciaFichaAdv * direccionY < 8 && tablero[x + distanciaFichaAdv * direccionX][y + distanciaFichaAdv * direccionY] == adversario) {
                distanciaFichaAdv++;
            }

            // Cambiar el color de las fichas del adversario
            if (x + distanciaFichaAdv * direccionX >= 0 && x + distanciaFichaAdv * direccionX < 8 && y + distanciaFichaAdv * direccionY >= 0 && y + distanciaFichaAdv * direccionY < 8 && tablero[x + distanciaFichaAdv * direccionX][y + distanciaFichaAdv * direccionY] == color && distanciaFichaAdv > 1) {
                for (int j = 1; j < distanciaFichaAdv; j++) {
                    tablero[x + j * direccionX][y + j * direccionY] = color;
                }
            }
        }
    }

    public char[][] imprimirMovimientosValidos(char color, boolean imprimir) { //Imprime y devuelve pos. validas.

        StringBuilder tableroString = new StringBuilder();
        tableroString.append(FORMATO_TABLERO);
        tableroString.append("  A B C D E F G H\n"); //Agrega encabezado de columnas.

        char oponente = (color == 'B') ? 'N' : 'B';

        char[][] tableroTemporal = new char[8][8];

        for (int i = 0; i < tablero.length; i++) {
            tableroString.append((i + 1)).append(" "); //Agrega número de fila.
            for (int j = 0; j < tablero[i].length; j++) {
                // tableroTemporal[i][j] = tablero[i][j];
                if (tablero[i][j] == 'V' && esMovimientoValido(i, j, color, oponente)) {
                    tableroTemporal[i][j] = '*';
                    tableroString.append('*' + " ");
                } else if (tablero[i][j] == 'V') {
                    tableroString.append(FICHA_VACIA + " ");
                } else if (tablero[i][j] == 'B') {
                    tableroString.append(FICHA_BLANCA + " ");
                } else if (tablero[i][j] == 'N') {
                    tableroString.append(FICHA_NEGRA + " ");
                }
            }
            tableroString.append("\n");
        }
        tableroString.append(FORMATO_RESTAURAR);
        if (imprimir) {
            System.out.println(tableroString);
        }

        return tableroTemporal;
    }


    @Override
    public String toString() {
        //imprime el tablero:

        StringBuilder tableroString = new StringBuilder();
        tableroString.append(FORMATO_TABLERO); //Pone el fondo blanco y los caract. oscuro.
        tableroString.append("  A B C D E F G H\n"); //Agrega encabezado de columnas.

        for (int i = 0; i < tablero.length; i++) {
            tableroString.append((i + 1)).append(" "); //Agrega número de fila.

            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 'B') {
                    tableroString.append(FICHA_BLANCA + " "); //Imprime ficha blanca.
                } else if (tablero[i][j] == 'N') {
                    tableroString.append(FICHA_NEGRA + " "); //Imprime ficha negra.
                } else if (tablero[i][j] == 'V') {
                    tableroString.append(FICHA_VACIA + " ");
                }

            }
            tableroString.append("\n");
        }
        tableroString.append("  A B C D E F G H\n");
        tableroString.append(FORMATO_RESTAURAR); //Restaura formato.
        return tableroString.toString();

    }
}
