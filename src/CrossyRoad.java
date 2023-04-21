import constants.Constants;

import java.io.*;
import java.util.*;

public class CrossyRoad {

    private static final int WIDTH = Constants.getWIDTH(); // Ample de la pantalla
    private static final int HEIGHT = Constants.getHEIGHT(); // Altura de la pantalla
    private static final char EMPTY_SYMBOL = Constants.getEmptySymbol(); // Símbol espai buit
    private static final char PLAYER_SYMBOL = Constants.getPlayerSymbol(); // Símbol Jugador
    private static final char OBSTACLE_SYMBOL = Constants.getObstacleSymbol(); // Símbol Obstacle
    private static final char GOAL_SYMBOL = Constants.getGoalSymbol(); // Símbol Final
    private static final int GOAL_ROW = Constants.getGoalRow(); // Fila de la meta
    private static int PLAYER_START_ROW = HEIGHT - 1; // Fila on comença el jugador
    private static int PLAYER_START_COL = WIDTH / 2; // Columna on comença el jugador
    private static final char[][] board = Constants.getBoard(); // Tauler del joc
    private static int score = 0; // Puntuació Jugador
    private static boolean gameOver = false; // Variable para indicar si el joc s'ha acabat

    public static void main(String[] args) {
        initializeBoard(); // Inicializar el tauler
        printBoard(); // Imprimir el tauler
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            movePlayer(scanner); // Moure el jugador
            moveObstacles(); // Moure els obstacles
            checkGoal(); // Comprovar si s'ha arribat a la meta
            checkCollisions(); // Comprovar si s'ha produït una col·lisió
            printBoard(); // Imprimir el tauler
        }
        ordenarPuntuacions("src/files/score.txt");
        saveScore();

    }


    private static void initializeBoard() {
        // Inicializar el tauler amb espais buits
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                board[row][col] = EMPTY_SYMBOL;
            }
        }

        // Colocar al jugador a la seva posicio d'inici
        board[PLAYER_START_ROW][PLAYER_START_COL] = PLAYER_SYMBOL;

        // Colocar els obstacles de forma aleatòria al tauler
        Random random = new Random();
        for (int row = 1; row < HEIGHT - 1; row++) {
            for (int col = 0; col < WIDTH; col++) {
                if (random.nextDouble() < 0.2) {
                    board[row][col] = OBSTACLE_SYMBOL;
                }
            }
        }

        // Colocar la meta a la fila superior
        board[GOAL_ROW][PLAYER_START_COL] = GOAL_SYMBOL;
    }

    private static void printBoard() {
        // Imprimir el tauler
        System.out.println();
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void movePlayer(Scanner scanner) {
        // Mou el jugador segons l'entrada per teclat
        System.out.print("Moure amunt (W), esquerra (A), dreta (D) o avall (S):  ");
        if (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            if (!inputLine.isEmpty()) {
                char input = inputLine.charAt(0);
                int newRow = PLAYER_START_ROW;
                int newCol = PLAYER_START_COL;
                switch (input) {
                    case 'w':
                        newRow--;
                        score++;
                        break;
                    case 'a':
                        newCol--;
                        break;
                    case 'd':
                        newCol++;
                        break;
                    case 's':
                        newRow++;
                        score--;
                        break;
                    default:
                        break;
                }

                if (newRow >= 0 && newRow < HEIGHT && newCol >= 0 && newCol < WIDTH) {
                    // El jugador ha xocat amb un obstacle
                    if (board[newRow][newCol] == OBSTACLE_SYMBOL) {
                        gameOver = true;
                    } else {
                        // Moure el jugador a la nova posicio
                        board[PLAYER_START_ROW][PLAYER_START_COL] = EMPTY_SYMBOL;
                        PLAYER_START_ROW = newRow;
                        PLAYER_START_COL = newCol;
                        board[PLAYER_START_ROW][PLAYER_START_COL] = PLAYER_SYMBOL;

                        if (newRow == GOAL_ROW) {
                            score++;
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

    private static void moveObstacles() {
        for (int row = 0; row < HEIGHT - 1; row++) {
            for (int col = WIDTH - 1; col >= 0; col--) {
                if (board[row][col] == OBSTACLE_SYMBOL) {
                    if (col == WIDTH - 1) {
                        board[row][col] = EMPTY_SYMBOL;
                        board[row][0] = OBSTACLE_SYMBOL;
                        break;
                    } else {
                        board[row][col + 1] = OBSTACLE_SYMBOL;
                        board[row][col] = EMPTY_SYMBOL;
                    }
                }
            }
        }
    }


    private static void checkGoal() {
        // Comprovar si s'ha arribat a la meta
        if (PLAYER_START_ROW == GOAL_ROW) {
            gameOver = true;
            System.out.println("Has arribat a la meta! Puntuació: " + score);
        }
    }

    private static void checkCollisions() {
        // Comprovar si el jugador s'ha xocat amb un obstacle
        if (board[PLAYER_START_ROW][PLAYER_START_COL] == OBSTACLE_SYMBOL) {
            gameOver = true;
            System.out.print("Has sigut atropellat, GAME OVER!!");
        }
    }
    private static void saveScore() {
        System.out.println("Introdueix el teu nom per guardar la puntuacio:");
        Scanner teclat = new Scanner(System.in);
        String name = teclat.nextLine();
        try {
            FileWriter writer = new FileWriter("src/files/score.txt", true);
            writer.write(name + ": " + score + "\n");
            writer.close();
            ordenarPuntuacions("src/files/score.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ordenarPuntuacions(String nomFitxer) {
        Map<String, Integer> puntuacions = new TreeMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(nomFitxer));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] dades = linea.split(":");
                if (dades.length >= 2) {
                    String nomJugador = dades[0].trim();
                    int puntuacio = Integer.parseInt(dades[1].trim());

                    if (puntuacions.containsKey(nomJugador)) {
                        puntuacions.put(nomJugador, puntuacions.get(nomJugador) + puntuacio);
                    } else {
                        puntuacions.put(nomJugador, puntuacio);
                    }
                } else {
                    System.out.println("Error: Format de línia incorrecte: " + linea);
                }
            }
            br.close();

            List<Map.Entry<String, Integer>> llistaOrdenada = new ArrayList<>(puntuacions.entrySet());
            Collections.sort(llistaOrdenada, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> entrada1, Map.Entry<String, Integer> entrada2) {
                    return entrada2.getValue().compareTo(entrada1.getValue());
                }
            });

            System.out.println("[LLISTA DE PUNTUACIONS]");
            for (Map.Entry<String, Integer> entrada : llistaOrdenada) {
                System.out.println(entrada.getKey() + ": " + entrada.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

