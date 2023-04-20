package ui;

/*public class Jugador {
    private static void movePlayer(Scanner scanner) {
        //Mou el jugador segons l'entrada per teclat
        System.out.print("Moure amunt (W), esquerra (A), dreta (D), avall (S) o passar torn (Q):  ");
        char input = scanner.nextLine().charAt(0);
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
            case 'q':
                break;
            default:
                break;
        }

        // Comprovar que el moviment no treu al jugador del tauler
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
                    System.out.println("Has arribat a la meta! Puntuació: " + score);
                }
            }
        }
    }
}
*/