package inici;

import java.util.Scanner;

import objects.Obstacles;
import constants.Constants;
import tauler.Mapa;
import objects.Jugador;
import files.Score;
/**
 * Classe Main que conté les crides als mèdes i el bucle principal.
 */
public class Main {
    /**
     * Mètode principal del joc CrossyRoad.
     * Inicialitza el tauler, imprimeix el tauler i permet al jugador moure's fins que el joc s'acabi.
     * Després d'acabar el joc, es realitza l'ordenació de les puntuacions i es guarda la puntuació del jugador.
     */
    public static void main(String[] args) {
        Mapa.initializeBoard(); // Inicializar el tauler
        Mapa.printBoard(); // Imprimir el tauler
        Scanner scanner = new Scanner(System.in);

        while (!Constants.getGameOver()) {
            Jugador.movePlayer(scanner); // Moure el jugador
            Obstacles.moveObstacles(); // Moure els obstacles
            Mapa.checkGoal(); // Comprovar si s'ha arribat a la meta
            Obstacles.checkCollisions(); // Comprovar si s'ha produït una col·lisió
            Mapa.printBoard(); // Imprimir el tauler
        }
        Score.ordenarPuntuacions("src/files/score.txt");//Mostrar la puntuació del fitxer ordenada de major a menor
        Score.saveScore();//Guardar la puntuació al fitxer score.txt

    }
}
