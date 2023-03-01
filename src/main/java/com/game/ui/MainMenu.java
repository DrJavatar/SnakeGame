package com.game.ui;

import com.game.utilties.TextUtilities;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label title;

    @FXML
    private Button hiscoresBtn;

    @FXML
    private Button startGameBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*TranslateTransition transition = new TranslateTransition(Duration.seconds(5), title);
        transition.setByX(600 - title.getWidth());
        transition.setByY(400 - title.getHeight());
        transition.setAutoReverse(true);
        transition.setCycleCount(TranslateTransition.INDEFINITE);

        // start the animation
        transition.play();*/

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(10), event -> moveLabel())
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void moveLabel() {
        double speed = 2;
        double labelSize = TextUtilities.calculateLabelSize(title.getText(), title.getFont());
        // Get the current position of the label
        double x = title.getLayoutX();
        double y = title.getLayoutY();

        // Calculate the new position of the label
        double newX = x + speed;
        double newY = y + speed;

        // If the label has gone off the edge of the window, wrap it around
        if (newX >= 600) {
            newX = -labelSize;
        }
        if (newY >= 400) {
            newY = -labelSize;
        }

        // Update the label's position
        title.setLayoutX(newX);
        title.setLayoutY(newY);
    }
}
