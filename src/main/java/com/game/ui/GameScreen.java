package com.game.ui;

import com.game.ui.canvas.GameCanvas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameScreen implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private HBox menuContainer;

    private GameCanvas skin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        skin = new GameCanvas(pane.getWidth(), pane.getHeight());
        pane.getChildren().add(skin.getCanvas());
    }
}
