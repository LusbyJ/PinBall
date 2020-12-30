/**
 * Class to create the Ball object and keep track of its state, and move the ball.
 *
 * @author Justin Lusby
 * @version 1.0
 * @date 1/20/19
 */
package project1;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class Ball extends Circle{
    public static final int RADIUS = 10;
    private static Circle ball = new Circle();

    /**
     * Relocates the ball to the bottom start bar.
     * Method called at initial start up and after reset
     * is pushed.
     */
    public void resetBall()
    {
        ball.relocate(Display.WIDTH/2, Display.HEIGHT - 50);
    }

    /**
     * Creates the ball object, sets the radius, and color
     * Adds a mouse listener to be used before pushing start
     * @return ball
     */
    public Circle createBall(){
        ball.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(Controller.getState() == 2){
                    moveBall(event.getX(), 0);
                }
            }
        });
        ball.setRadius(RADIUS);
        ball.setFill(Color.RED);
        resetBall();
        return ball;
    }

    /**
     * Moves the ball on the game board while playing
     * @param dx units to move along the x-axis
     * @param dy units to move along the y-axis
     */
    public void moveBall(double dx, double dy){
        ball.setLayoutX(ball.getLayoutX() + dx);
        ball.setLayoutY(ball.getLayoutY() + dy);
    }

    /**
     * Method to return the y position of the ball
     * @return layoutY
     */
    public static double getY(){
        return ball.getLayoutY();
    }

    /**
     * Method to return the x position of the ball
     * @return layoutX
     */
    public static double getX(){
        return ball.getLayoutX();
    }
}
