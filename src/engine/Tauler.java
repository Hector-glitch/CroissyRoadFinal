package engine;

/*public class Tauler {
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