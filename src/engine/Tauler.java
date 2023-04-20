package engine;

/*public class Tauler {
    private static final int WIDTH = 10; // Ample de la pantalla
    private static final int HEIGHT = 10; // Altura de la pantalla
    private static final char EMPTY_SYMBOL = '.'; // Símbol espai buit
    private static final char PLAYER_SYMBOL = 'P'; // Símbol Jugador
    private static final char OBSTACLE_SYMBOL = '#'; // Símbol Obstacle
    private static final char GOAL_SYMBOL = 'G'; // Símbol Final
    private static final int GOAL_ROW = 0; // Fila de la meta
    private static int PLAYER_START_ROW = HEIGHT - 1; // Fila on comença el jugador
    private static int PLAYER_START_COL = WIDTH / 2; // Columna on comença el jugador

    private static final char[][] board = new char[HEIGHT][WIDTH]; // Tauler del joc
    private static int score = 0; // Puntuació Jugador
    private static boolean gameOver = false; // Variable para indicar si el joc s'ha acabat


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
}
*/