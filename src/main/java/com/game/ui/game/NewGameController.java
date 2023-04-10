package com.game.ui.game;

import com.game.di.DependencyManager;
import com.game.engine.GameSettings;
import com.game.engine.world.GameWorld;
import com.game.ui.controller.ControllerManager;
import com.game.ui.controller.GameUIController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewGameController extends GameUIController {

    private final NewGameModel model = DependencyManager.get("m_new_game");

    @FXML
    private ChoiceBox<GameSettings.Difficulty> modes;

    @FXML
    private TextField nameInput;

    @FXML
    private Button startBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for(GameSettings.Difficulty d : GameSettings.Difficulty.values()) {
            modes.getItems().add(d);
        }

        modes.setValue(GameSettings.Difficulty.EASY);

        model.difficulty.bind(modes.valueProperty());

        startBtn.disableProperty().bind(model.playerName.isEmpty());

        model.playerName.bind(nameInput.textProperty());
    }

    @FXML
    public void onCancel() throws IOException {
        ControllerManager.switchToMainMenu(this);
    }

    @FXML
    public void onStart() throws IOException {
        GameWorld world = DependencyManager.get("world");

        world.reset();

        ControllerManager.switchToGame(this);
    }
}
