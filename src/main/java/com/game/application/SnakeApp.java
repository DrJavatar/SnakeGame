package com.game.application;

import com.game.di.DependencyManager;
import com.game.ui.MainMenu;
import com.game.ui.controller.ControllerManager;
import com.game.ui.game.NewGameModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class SnakeApp extends Application {

    @Override
    public void init() throws Exception {
        super.init();

        DependencyManager.set("m_new_game", new NewGameModel());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL uiFxml = SnakeApp.class.getResource("main.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        MainMenu mainMenu = new MainMenu();
        mainMenu.setPrimaryStage(primaryStage);
        fxmlLoader.setController(mainMenu);
        fxmlLoader.setLocation(uiFxml);
        AnchorPane pane = fxmlLoader.load();
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}
