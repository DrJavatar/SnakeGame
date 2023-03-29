package com.game.ui.game;

import com.game.di.DependencyManager;
import com.game.engine.GameSettings;
import com.game.ui.controller.ControllerManager;
import com.game.ui.controller.GameUIController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewGameController extends GameUIController {

    private final NewGameModel model = DependencyManager.get("m_new_game");

    @FXML
    private ChoiceBox<GameSettings.Difficulty> modes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for(GameSettings.Difficulty d : GameSettings.Difficulty.values()) {
            modes.getItems().add(d);
        }

        modes.setValue(GameSettings.Difficulty.EASY);

        modes.setConverter(new StringConverter<>() {
            @Override
            public String toString(GameSettings.Difficulty object) {
                return object == null ? "N/A" : object.name();
            }

            @Override
            public GameSettings.Difficulty fromString(String string) {
                if(string.equals("N/A")) {
                    return GameSettings.Difficulty.EASY;
                }
                return GameSettings.Difficulty.valueOf(string);
            }
        });

    }

    @FXML
    public void onCancel() throws IOException {
        ControllerManager.switchToMainMenu(this);
    }
}
