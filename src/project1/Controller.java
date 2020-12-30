/**
 * Class to encapsulate button and mouse state
 *
 * @author Justin Lusby
 * @version 1.0
 * @date 1/20/19
 */
package project1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Controller {
    private static Button startButton =  new Button("START");
    private static Button resetButton =  new Button("RESET");
    protected static Label scoreLabel = new Label();
    private static int state;
    private double x;
    private double y;

    /**
     * Creates the start button and event handler
     * updates state of game
     * @return startButton
     */
    public Button createStartButton(){
        state = 2;
        startButton.setStyle("-fx-font: 14 arial; -fx-base: Yellow;");
        startButton.setPrefWidth(Display.WIDTH /2.75);
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //change state to start the game
                state = 1;
                startButton.setStyle("-fx-font: 14 arial; -fx-base: Gray;");
                resetButton.setStyle("-fx-font: 14 arial; -fx-base: Yellow;");
            }
        });
        return startButton;
    }

    /**
     * Creates the reset Button and event Handler
     * updates state of game
     * @return resetButton
     */
    public Button createResetButton(){
        resetButton.setStyle("-fx-font: 14 arial; -fx-base: Gray;");
        resetButton.setPrefWidth(Display.WIDTH /2.75);
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //reset state of game upon button press
                state = 0;
                resetButton.setStyle("-fx-font: 14 arial; -fx-base: Gray;");
                startButton.setStyle("-fx-font: 14 arial; -fx-base: Yellow;");
            }
        });
        return resetButton;
    }

    /**
     * Creates the score label
     * calls Board method setScore to update
     * @return scoreLabel
     */
    public Label scoreLabel(){
        scoreLabel.setText("" +Board.setScore(0));
        scoreLabel.setAlignment(Pos.CENTER);
        scoreLabel.setStyle("-fx-font: 14 ariel;");
        scoreLabel.setTextFill(Color.RED);
        scoreLabel.setPrefWidth(Display.WIDTH /3.65);
        return scoreLabel;
    }

    /**
     * Method for keeping track of state of game
     * @return state
     */
    public static int getState(){
        return state;
    }
}
