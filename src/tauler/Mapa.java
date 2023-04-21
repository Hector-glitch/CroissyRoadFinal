package tauler;

import java.util.Random;
import constants.Constants;

public class Mapa {
    /**
     * Inicialitza el tauler del joc amb espais buits, col·loca el jugador a la posició d'inici,
     * col·loca els obstacles de forma aleatòria i col·loca la meta a la fila superior.
     */
    public static void initializeBoard() {
        // Inicializar el tauler amb espais buits
        for (int row = 0; row < Constants.getHEIGHT(); row++) {
            for (int col = 0; col < Constants.getWIDTH(); col++) {
                Constants.getBoard()[row][col] = Constants.getEmptySymbol();
            }
        }

        char[][] board = Constants.getBoard();
        // Colocar al jugador a la seva posicio d'inici
        board[Constants.getPlayerStartRow()][Constants.getPlayerStartCol()] = Constants.getPlayerSymbol();
        Constants.setBoard(board);
        // Colocar els obstacles de forma aleatòria al tauler
        Random random = new Random();
        for (int row = 1; row < Constants.getHEIGHT() - 1; row++) {
            for (int col = 0; col < Constants.getWIDTH(); col++) {
                if (random.nextDouble() < 0.2) {
                    Constants.getBoard()[row][col] = Constants.getObstacleSymbol();
                }
            }
        }

        // Colocar la meta a la fila superior
        board[Constants.getGoalRow()][Constants.getPlayerStartCol()] = Constants.getGoalSymbol();
        Constants.setBoard(board);
    }
    /**
     * Imprimeix el tauler del joc.
     */
    public static void printBoard() {
        // Imprimir el tauler
        System.out.println();
        for (int row = 0; row < Constants.getHEIGHT(); row++) {
            for (int col = 0; col < Constants.getWIDTH(); col++) {
                System.out.print(Constants.getBoard()[row][col] + " ");
            }
            System.out.println();
        }
    }
    /**
     * Comprova si el jugador ha arribat a la meta.
     */
    public static void checkGoal() {
        // Comprovar si s'ha arribat a la meta
        if (Constants.getPlayerStartRow() == Constants.getGoalRow()) {
            Constants.setGameOver(true);
            System.out.println("Has arribat a la meta! Puntuació: " + Constants.getScore());
        }
    }
}
