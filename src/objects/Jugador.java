package objects;

import constants.Constants;
import java.util.Scanner;
/**
 * Classe Jugador que conté els mètodes relacionats amb el jugador.
 */
public class Jugador extends Esser {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void moure() {
        // Mou el jugador segons l'entrada per teclat
        System.out.print("Moure amunt (W), esquerra (A), dreta (D) o avall (S):  ");
        if (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            if (!inputLine.isEmpty()) {
                char input = inputLine.charAt(0);
                int newRow = Constants.getPlayerStartRow();
                int newCol = Constants.getPlayerStartCol();
                switch (input) {
                    case 'w':
                        newRow--;
                        Constants.setScore(Constants.getScore()+1);
                        break;
                    case 'a':
                        newCol--;
                        break;
                    case 'd':
                        newCol++;
                        break;
                    case 's':
                        newRow++;
                        Constants.setScore(Constants.getScore()-1);
                        break;
                    default:
                        break;
                }
                char[][] board = Constants.getBoard();
                if (newRow >= 0 && newRow < Constants.getHEIGHT() && newCol >= 0 && newCol < Constants.getWIDTH()) {
                    // El jugador ha xocat amb un obstacle
                    if (board[newRow][newCol] == Constants.getObstacleSymbol()) {
                        Constants.setGameOver(true);
                    } else {
                        // Moure el jugador a la nova posicio
                        board[Constants.getPlayerStartRow()][Constants.getPlayerStartCol()] = Constants.getEmptySymbol();
                        Constants.setBoard(board);
                        Constants.setPlayerStartRow(newRow);
                        Constants.setPlayerStartCol(newCol);
                        board[Constants.getPlayerStartRow()][Constants.getPlayerStartCol()] = Constants.getPlayerSymbol();
                        Constants.setBoard(board);

                        if (newRow == Constants.getGoalRow()) {
                            Constants.setScore(Constants.getScore()+1);
                        }
                    }
                }
            } else {
                System.out.println("No s'ha ingressat cap text. Es passa de torn.");
            }
        } else {
            System.out.println("No hi ha cap entrada disponible.");
        }
    }
    /**
     * Mou el jugador en resposta a la introducció de l'usuari.
     *
     * @param scanner objecte Scanner per llegir l'entrada de l'usuari
     */
   /* public static void movePlayer(Scanner scanner) {
        // Mou el jugador segons l'entrada per teclat
        System.out.print("Moure amunt (W), esquerra (A), dreta (D) o avall (S):  ");
        if (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            if (!inputLine.isEmpty()) {
                char input = inputLine.charAt(0);
                int newRow = Constants.getPlayerStartRow();
                int newCol = Constants.getPlayerStartCol();
                switch (input) {
                    case 'w':
                        newRow--;
                        Constants.setScore(Constants.getScore()+1);
                        break;
                    case 'a':
                        newCol--;
                        break;
                    case 'd':
                        newCol++;
                        break;
                    case 's':
                        newRow++;
                        Constants.setScore(Constants.getScore()-1);
                        break;
                    default:
                        break;
                }
                char[][] board = Constants.getBoard();
                if (newRow >= 0 && newRow < Constants.getHEIGHT() && newCol >= 0 && newCol < Constants.getWIDTH()) {
                    // El jugador ha xocat amb un obstacle
                    if (board[newRow][newCol] == Constants.getObstacleSymbol()) {
                        Constants.setGameOver(true);
                    } else {
                        // Moure el jugador a la nova posicio
                        board[Constants.getPlayerStartRow()][Constants.getPlayerStartCol()] = Constants.getEmptySymbol();
                        Constants.setBoard(board);
                        Constants.setPlayerStartRow(newRow);
                        Constants.setPlayerStartCol(newCol);
                        board[Constants.getPlayerStartRow()][Constants.getPlayerStartCol()] = Constants.getPlayerSymbol();
                        Constants.setBoard(board);

                        if (newRow == Constants.getGoalRow()) {
                            Constants.setScore(Constants.getScore()+1);
                        }
                    }
                }
            } else {
                System.out.println("No s'ha ingressat cap text. Es passa de torn.");
            }
        } else {
            System.out.println("No hi ha cap entrada disponible.");
        }
    }*/
}
