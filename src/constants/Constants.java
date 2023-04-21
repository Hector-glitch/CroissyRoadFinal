package constants;

public class Constants {
    private static  final int WIDTH = 10; // Ample de la pantalla
    private static  final int HEIGHT = 10; // Altura de la pantalla
    private static  final char EMPTY_SYMBOL = '.'; // Símbol espai buit
    private static  final char PLAYER_SYMBOL = 'P'; // Símbol Jugador
    private static  final char OBSTACLE_SYMBOL = '#'; // Símbol Obstacle
    private static  final char GOAL_SYMBOL = 'G'; // Símbol Final
    private static  final int GOAL_ROW = 0; // Fila de la meta
    private static  final char[][] board = new char[HEIGHT][WIDTH]; // Tauler del joc

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static char getEmptySymbol() {
        return EMPTY_SYMBOL;
    }

    public static char getPlayerSymbol() {
        return PLAYER_SYMBOL;
    }

    public static char getObstacleSymbol() {
        return OBSTACLE_SYMBOL;
    }

    public static char getGoalSymbol() {
        return GOAL_SYMBOL;
    }

    public static int getGoalRow() {
        return GOAL_ROW;
    }

    public static char[][] getBoard() {
        return board;
    }
}
