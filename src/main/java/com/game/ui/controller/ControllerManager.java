package com.game.ui.controller;

import com.game.application.SnakeApp;
import com.game.ui.GameScreenController;
import com.game.ui.MainMenu;
import com.game.ui.game.NewGameController;
import com.game.ui.hiscores.HiscoreController;
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

    public static void switchToHiscore(GameUIController from) throws IOException {
        URL uiFxml = SnakeApp.class.getResource("hiscore.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        HiscoreController hiscore = new HiscoreController();
        hiscore.setPrimaryStage(from.getPrimaryStage());
        fxmlLoader.setController(hiscore);
        fxmlLoader.setLocation(uiFxml);
        Parent parent = fxmlLoader.load();
        from.primaryStage.setScene(new Scene(parent));
    }

    public static void switchToNewGame(GameUIController from) throws IOException {
        URL uiFxml = SnakeApp.class.getResource("newgame.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        NewGameController hiscore = new NewGameController();
        hiscore.setPrimaryStage(from.getPrimaryStage());
        fxmlLoader.setController(hiscore);
        fxmlLoader.setLocation(uiFxml);
        Parent parent = fxmlLoader.load();
        from.primaryStage.setScene(new Scene(parent));
    }

    public static void switchToGame(GameUIController from) throws IOException {
        URL uiFxml = SnakeApp.class.getResource("game.fxml");
        FXMLLoader loader = new FXMLLoader();
        GameScreenController screen = new GameScreenController();
        screen.setPrimaryStage(from.getPrimaryStage());
        loader.setController(screen);
        loader.setLocation(uiFxml);
        Parent parent = loader.load();
        from.primaryStage.setScene(new Scene(parent));
        screen.initGameControls();
    }

}
