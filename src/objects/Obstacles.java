package objects;

import constants.Constants;
/**
 * Classe Obstacles que conté els mètodes relacionats amb els obstacles i comprovació de xocs.
 */
public class Obstacles extends Esser {
    @Override
    public void moure() {
        char[][] board = Constants.getBoard();
        for (int row = 0; row < Constants.getHEIGHT() - 1; row++) {
            for (int col = Constants.getWIDTH() - 1; col >= 0; col--) {
                if (board[row][col] == Constants.getObstacleSymbol()) {
                    if (col == Constants.getWIDTH() - 1) {
                        board[row][col] = Constants.getEmptySymbol();
                        Constants.setBoard(board);
                        board[row][0] = Constants.getObstacleSymbol();
                        Constants.setBoard(board);
                        break;
                    } else {
                        board[row][col + 1] = Constants.getObstacleSymbol();
                        Constants.setBoard(board);
                        board[row][col] = Constants.getEmptySymbol();
                        Constants.setBoard(board);
                    }
                }
            }
        }
    }
    /**
     * Mou els obstacles cap avall en cada iteració del joc.
     * Quan un obstacle arriba a la fila inferior, és reposicionat a la fila superior de forma aleatòria.
     */
    /*public static void moveObstacles() {
        char[][] board = Constants.getBoard();
        for (int row = 0; row < Constants.getHEIGHT() - 1; row++) {
            for (int col = Constants.getWIDTH() - 1; col >= 0; col--) {
                if (board[row][col] == Constants.getObstacleSymbol()) {
                    if (col == Constants.getWIDTH() - 1) {
                        board[row][col] = Constants.getEmptySymbol();
                        Constants.setBoard(board);
                        board[row][0] = Constants.getObstacleSymbol();
                        Constants.setBoard(board);
                        break;
                    } else {
                        board[row][col + 1] = Constants.getObstacleSymbol();
                        Constants.setBoard(board);
                        board[row][col] = Constants.getEmptySymbol();
                        Constants.setBoard(board);
                    }
                }
            }
        }
    }*/
    /**
     * Comprova si el jugador s'ha xocat amb un obstacle.
     */
    public static void checkCollisions() {
        char[][] board = Constants.getBoard();
        // Comprovar si el jugador s'ha xocat amb un obstacle
        if (board[Constants.getPlayerStartRow()][Constants.getPlayerStartCol()] == Constants.getObstacleSymbol()) {
            Constants.setGameOver(true);
            System.out.print("Has sigut atropellat, GAME OVER!!");
        }
    }


}
