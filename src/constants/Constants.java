package constants;

public class Constants {
    private static final int WIDTH = 10; // Ample de la pantalla
    private static final int HEIGHT = 10; // Altura de la pantalla
    private static final char EMPTY_SYMBOL = '.'; // Símbol espai buit
    private static final char PLAYER_SYMBOL = 'P'; // Símbol Jugador
    private static final char OBSTACLE_SYMBOL = '#'; // Símbol Obstacle
    private static final char GOAL_SYMBOL = 'G'; // Símbol Final
    private static final int GOAL_ROW = 0; // Fila de la meta
    private static int PLAYER_START_ROW = HEIGHT - 1; // Fila on comença el jugador
    private static int PLAYER_START_COL = WIDTH / 2; // Columna on comença el jugador
    private static char[][] board = new char[HEIGHT][WIDTH]; // Tauler del joc
    private static  int score = 0; // Puntuació Jugador
    private static  boolean gameOver = false; // Variable para indicar si el joc s'ha acabat

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
    public static int getPlayerStartRow() {
        return PLAYER_START_ROW;
    }
    public static void setPlayerStartRow (int PLAYER_START_ROW){
        Constants.PLAYER_START_ROW = PLAYER_START_ROW;
    }
    public static int getPlayerStartCol() {
        return PLAYER_START_COL;
    }
    public static void setPlayerStartCol(int PLAYER_START_COL){
        Constants.PLAYER_START_COL = PLAYER_START_COL;
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
    public static void setBoard(char[][] board){
        Constants.board = board;
    }
    public static int getScore() {
        return score;
    }
    public static void setScore(int score){
        Constants.score = score;
    }
    public static boolean getGameOver() {
        return gameOver;
    }
    public static void setGameOver(boolean gameOver){
        Constants.gameOver = gameOver;
    }
}
