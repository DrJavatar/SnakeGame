package com.game.ui;

import com.game.di.DependencyManager;
import com.game.engine.entity.Direction;
import com.game.engine.entity.snake.Snake;
import com.game.engine.world.GameWorld;
import com.game.ui.canvas.GameCanvas;
import com.game.ui.controller.ControllerManager;
import com.game.ui.controller.GameUIController;
import com.game.ui.game.HiscoreModel;
import com.game.ui.game.NewGameModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameScreenController extends GameUIController {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label modeLabel;

    private GameCanvas skin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        skin = new GameCanvas(800, 591);
        pane.getChildren().add(skin.getCanvas());

        HiscoreModel model = DependencyManager.get("hiscores");
        NewGameModel newGameModel = DependencyManager.get("m_new_game");

        scoreLabel.textProperty().bind(Bindings.createStringBinding(() -> Integer.toString(model.score.get()), model.score));
        modeLabel.textProperty().bind(Bindings.createStringBinding(() -> newGameModel.difficulty.get().name(), newGameModel.difficulty));

    }

    @FXML
    public void onQuit() throws IOException {
        GameWorld world = DependencyManager.get("world");
        world.getState().onGameEnd(world.getSettings().getName());
        skin.stop();
        ControllerManager.switchToMainMenu(this);
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
        world.reset();
        world.placeEntities(skin);
        skin.start();
    }
}
