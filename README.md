# Proyecto Final de Programación



![Pantalla inicial](https://i.imgur.com/s4p17rc.png)
## Descripción

Este proyecto de programación consiste en la creación de un juego llamado "*Reversi*",
también conocido como "*Othello*".
- El juego consiste en la colocación de fichas (⚫⚪) en posiciones adyacentes a las del adversario (los asteriscos indican las posiciones a las que es posible mover), de forma que se capturen las fichas del oponente que haya en medio.
  - Hay varias modalidades de juego que se han pedido para este proyecto, que son:
    - Jugador contra Jugador 🙂🙂
    - Jugador contra Máquina 🙂🤖
    - Máquina contra Máquina 🤖🤖
- Gana el jugador que tenga más fichas de su color al finalizar la partida (cuando no se puedan realizar más movimientos).

## Índice

- [Descargando el proyecto](#descargando-el-proyecto)
- [Uso y posibles fallos de visualización](#uso)
- [Miembros del grupo](#proyecto-realizado-por)
- [Licencia](#licencia)
- [Diagramas](#diagramas)

## Descargando el proyecto

Para empezar, debes clonar el repositorio en tu ordenador, para ello ejecuta:

```bash
git clone https://github.com/Juan-A/proyectoFinalProgramacion-1DAW.git
```
O bien, descarga el proyecto desde [aquí](https://github.com/Juan-A/proyectoFinalProgramacion-1DAW/archive/refs/heads/main.zip).

## Uso
> Si no consigues ver las figuras que usamos para las fichas correctamente, puedes cambiarlas directamente por letras (B,N,V) (que en cualquier caso, sí que funcionarán) en la clase `Tablero` (constantes `FICHA_X`), ya que se ha realizado la representación de forma independiente con la forma en que se procesa el tablero.

- Windows, Linux y Mac:
Abre el proyecto con IntelliJ IDEA o con cualquier otro IDE y ejecuta el archivo `Main.java` del proyecto.
- Windows 11 (En otras no funcionan las figuras):
    1. IntelliJ : Genera los artifacts con estas [*Instrucciones*](https://www.jetbrains.com/help/idea/working-with-artifacts.html#artifact_configs)
    2. Una vez hayas generado el ejecutable, lanza el archivo `Jugar.bat` que encontrarás en la raíz del proyecto.
- Linux y Mac:
    1. IntelliJ : Genera los artifacts con estas [*Instrucciones*](https://www.jetbrains.com/help/idea/working-with-artifacts.html#artifact_configs)
    2. Una vez hayas generado el ejecutable, lanza el archivo `Jugar.sh` que encontrarás en la raíz del proyecto.
> ¡Recuerda! En Linux, añade permisos de ejecución al archivo `.sh` con el comando `chmod +x Jugar.sh` en la terminal ó con el explorador de archivos (``Clic derecho -> Propiedades -> Permisos``).


## Proyecto realizado por:

- *Juan Antonio Herrero Centurión*
- *Juan Jesus Rivillas Canalejas*
- *Pablo Robles Navas*
- *Daniel Pascual Mora*

## Licencia

Este proyecto está bajo la Licencia Pública General de GNU versión 3.0. Puedes encontrar una copia de la licencia en el archivo [LICENSE](LICENSE) o en [https://www.gnu.org/licenses/gpl-3.0.en.html](https://www.gnu.org/licenses/gpl-3.0.en.html).

## Diagramas
![Diagrama de clases](https://i.imgur.com/6xfMh55.png)
---
