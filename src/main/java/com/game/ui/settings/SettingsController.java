package com.game.ui.settings;

import com.game.di.DependencyManager;
import com.game.ui.controller.ControllerManager;
import com.game.ui.controller.GameUIController;
import com.game.ui.game.SettingsModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController extends GameUIController {

    @FXML
    private TextField saveDir;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SettingsModel model = DependencyManager.get("settings");
        saveDir.setEditable(false);
        saveDir.textProperty().bind(model.saveDirectory);
    }

    @FXML
    public void onChange() {
        SettingsModel model = DependencyManager.get("settings");
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Saves Directory");
        chooser.setInitialDirectory(new File(model.saveDirectory.get()));

        File result = chooser.showDialog(getPrimaryStage());

        if(result != null) {
            model.saveDirectory.set(result.getAbsolutePath());
        }
    }

    @FXML
    public void openSaves() {
        SettingsModel model = DependencyManager.get("settings");

        if(Desktop.isDesktopSupported()) {
            File directory = new File(model.saveDirectory.get());
            if(directory.exists() && directory.isDirectory()) {
                try {
                    Desktop.getDesktop().open(directory);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @FXML
    public void onMainMenu() throws IOException {
        ControllerManager.switchToMainMenu(this);
    }
}
