package com.game.ui.controller;

import com.game.application.SnakeApp;
import com.game.ui.MainMenu;
import com.game.ui.settings.SettingsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public class ControllerManager {
    private ControllerManager() {}

    public static void switchToMainMenu(GameUIController from) throws IOException {
        URL uiFxml = SnakeApp.class.getResource("main.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        MainMenu mainMenu = new MainMenu();
        mainMenu.setPrimaryStage(from.getPrimaryStage());
        fxmlLoader.setController(mainMenu);
        fxmlLoader.setLocation(uiFxml);
        Parent parent = fxmlLoader.load();
        from.primaryStage.setScene(new Scene(parent));
    }

    public static void switchToSettings(GameUIController from) throws IOException {
        URL uiFxml = SnakeApp.class.getResource("settings.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        SettingsController settings = new SettingsController();
        settings.setPrimaryStage(from.getPrimaryStage());
        fxmlLoader.setController(settings);
        fxmlLoader.setLocation(uiFxml);
        Parent parent = fxmlLoader.load();
        from.primaryStage.setScene(new Scene(parent));
    }

}
