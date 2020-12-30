/**
 * Main game loop, Class to control the game.
 *
 * @author Justin Lusby
 * @version 1.0
 * @date 1/20/19
 */
package project1;
import javafx.animation.AnimationTimer;

public class GameManager {
    private static int dx = 1;
    private static int dy = -3;
    private static int x;
    private static int y;
    private static int borderHit = 0;
    private static long time = 10_000_000;  // determines speed of animation
    private static long lastUpdate = 0;

    /**
     * Main game loop for the game.
     *
     */
    public static void playGame() {
        AnimationTimer a = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= time) {

                    //check for tile hits and border hits
                    if (Controller.getState() == 1) {
                        if (borderHit < 3) {
                            lastUpdate = now;
                            new Ball().moveBall(dx, dy);

                            //check if ball hits x axis border
                            if (Ball.getX() >= Display.WIDTH - Ball.RADIUS || Ball.getX() <= Ball.RADIUS) {
                                dx = -dx;
                                borderHit++;
                            }

                            //check if ball hits y axis border
                            if (Ball.getY() > Display.HEIGHT  - 40 || Ball.getY() <= Ball.RADIUS) {
                                dy = -dy;
                                borderHit++;
                            }
                            //check if ball hits active tile
                            x = (int) Math.round(((Ball.getX()-20)/40));
                            y = (int) Math.round(((Ball.getY()+10)/40));
                            System.out.println(x);
                            if(x >= 0 && x < Board.boardCols && y >= 0 && y < Board.boardRows) {
                                if (Board.getTileState(x, y) == 1) {
                                    Board.setTile(x, y, false);
                                    borderHit = 0;
                                    Controller.scoreLabel.setText("" + Board.setScore(10));
                                }
                            }
                        }
                    }
                    //if reset is hit, stop the animation, reset board and score, call playGame()
                    if(Controller.getState() == 0) {
                        stop();
                        new Board().createBoard();
                        new Controller().createStartButton();
                        new Controller().createResetButton();
                        new Ball().createBall();
                        Controller.scoreLabel.setText("0");
                        Board.score = 0;
                        borderHit = 0;
                        dx = 1;
                        dy = -3;
                        playGame();
                    }
                }
            }
        };
        a.start();
    }
}
