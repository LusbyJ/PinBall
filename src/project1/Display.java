/**
 * Class to create the GUI display.
 * Entry point for the program, updates GUI in response to Game Manager
 *
 * @author Justin Lusby
 * @version 1.0
 * @date 1/20/19
 */
package project1;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Display extends Application {
    public static final int WIDTH = 240;
    public static final int HEIGHT = 460;

    /**
     * Creates the star bar for the ball.
     * @return startBar
     */
    public HBox createStartBar(){
        HBox startBar = new HBox();
        startBar.setStyle("-fx-background-color: Gray");
        startBar.setPrefWidth(WIDTH);
        startBar.setPrefHeight(20);
        return startBar;
    }

    /**
     * Creates the control bar for the buttons and score label
     * @return controlBar
     */
    public HBox createControlBar(){
        HBox controlBar = new HBox();
        controlBar.setPrefWidth(WIDTH);
        controlBar.setStyle("-fx-background-color: BLACK");
        controlBar.setPrefHeight(20);
        controlBar.getChildren().addAll(new Controller().createStartButton(), new Controller().scoreLabel(),
                new Controller().createResetButton());
        return controlBar;
    }

    public static void main(String[] args) { launch(args); }
    @Override

    //Put everything together
    public void start(Stage primaryStage) throws Exception{

        BorderPane root = new BorderPane();
        primaryStage.setTitle("Pinball");

        //place all components onto the the root node
        root.setTop(new Board().createBoard());
        root.setCenter(createStartBar());
        root.setBottom(createControlBar());
        root.getChildren().add(new Ball().createBall());

        //show the stage with the root node
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
        GameManager.playGame();
    }
}
