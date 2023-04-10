package com.game.ui;

import com.game.di.DependencyManager;
import com.game.engine.entity.Direction;
import com.game.engine.entity.snake.Snake;
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
        GameWorld world = DependencyManager.get("world");
        primaryStage.getScene().setOnKeyPressed(event -> {
            Direction direction = null;
            Snake snake = world.getSnake();
            switch (event.getCode()) {
                case A -> direction = Direction.LEFT;
                case D -> direction = Direction.RIGHT;
                case W -> direction = Direction.UP;
                case S -> direction = Direction.DOWN;
                default -> {
                }
            }

            if(snake.getDirection() == Direction.LEFT && direction == Direction.RIGHT) {
                return;
            } else if(snake.getDirection() == Direction.RIGHT && direction == Direction.LEFT) {
                return;
            } else if(snake.getDirection() == Direction.UP && direction == Direction.DOWN) {
                return;
            } else if(snake.getDirection() == Direction.DOWN && direction == Direction.UP) {
                return;
            }

            snake.setDirection(direction);
        });
        world.placeEntities(skin);
        skin.start();
    }
}
