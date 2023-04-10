package com.game.ui;

import com.game.di.DependencyManager;
import com.game.engine.entity.Direction;
import com.game.engine.world.GameWorld;
import com.game.ui.canvas.GameCanvas;
import com.game.ui.controller.GameUIController;
import com.game.utilties.Vector2d;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static com.game.ui.canvas.GameCanvas.BLOCK_SIZE;

public class GameScreenController extends GameUIController {

    @FXML
    private AnchorPane pane;

    private GameCanvas skin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        skin = new GameCanvas(800, 591);
        pane.getChildren().add(skin.getCanvas());
    }

    @FXML
    public void onQuit() {
        skin.stop();
    }

    public void initGameControls() {
        primaryStage.getScene().setOnKeyPressed(event -> {
            Direction direction = null;
            GameWorld world = DependencyManager.get("world");
            Vector2d dir = world.getSnake().getDirectionPos();
            switch (event.getCode()) {
                case A -> direction = Direction.LEFT;
                case D -> direction = Direction.RIGHT;
                case W -> direction = Direction.UP;
                case S -> direction = Direction.DOWN;
                default -> {
                }
            }

            if (direction != null && (dir.getX() != -direction.getDx() || dir.getY() != -direction.getDy())) {
                dir.setX(direction.getDx() * BLOCK_SIZE);
                dir.setY(direction.getDy() * BLOCK_SIZE);
            }
        });
        skin.start();
    }
}
