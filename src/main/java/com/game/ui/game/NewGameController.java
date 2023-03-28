package com.game.ui.game;

import com.game.ui.controller.ControllerManager;
import com.game.ui.controller.GameUIController;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewGameController extends GameUIController {



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void onCancel() throws IOException {
        ControllerManager.switchToMainMenu(this);
    }
}