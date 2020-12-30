/**
 * Class to create and manipulate the game board
 *
 * @author Justin Lusby
 * @version 1.0
 * @date 1/20/19
 */
package project1;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Board extends Rectangle {
    public static int boardRows = 10;
    public static int boardCols = 6;
    private static int tileSize = 40;
    private static GridPane board = new GridPane();
    public static int score;
    private static Rectangle[][] tiles = new Rectangle[boardCols][boardRows];

    /**
     * method to set the tile color
     * @param x     x coordinate of tile
     * @param y     y coordinate of tile
     * @param state determines color of tile
     * @return hit value
     */
    public static void setTile(int x, int y, boolean state) {
        if (!state) tiles[x][y].setFill(Color.BLUE);
        else tiles[x][y].setFill(Color.ORANGE);
    }

    /**
     * method to check the tile color for the collision detection
     * @param x x coordinate
     * @param y y coordinate
     * @return hit value
     */
    public static int getTileState(int x, int y) {
        if (tiles[x][y].getFill() == Color.ORANGE) {
            return 1;
        } else
            return 0;
    }

    /**
     * Creates the board grid, fills it with tiles, resets the ball to start bar
     *
     * @return newly created board
     */
    public static GridPane createBoard() {
        board.setMaxSize(boardCols * tileSize, boardRows * tileSize);
        for (int x = 0; x < boardCols; x++) {
            for (int y = 0; y < boardRows; y++) {
                tiles[x][y] = new Rectangle(tileSize, tileSize);
                tiles[x][y].setStroke(Color.BLACK);
                setTile(x, y, Math.random() < 0.09);
                board.add(tiles[x][y], x, y);
            }
        }
        return board;
    }

    /**
     * sets and increments the score value
     *
     * @param points
     */
    public static int setScore(int points) {

        score = score + points;
        return score;
    }
}


