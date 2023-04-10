package com.game.ui.game;

import com.game.di.DependencyManager;
import com.game.engine.GameSettings;
import com.game.engine.world.GameWorld;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class NewGameModel {

    public final SimpleStringProperty playerName = new SimpleStringProperty();
    public final ObjectProperty<GameSettings.Difficulty> difficulty = new SimpleObjectProperty<>(GameSettings.Difficulty.EASY);

    public NewGameModel() {

        difficulty.addListener((observable, oldValue, newValue) -> {
            GameWorld world = DependencyManager.get("world");
            world.getSettings().setDifficulty(newValue);
        });

        playerName.addListener((observable, oldValue, newValue) -> {
            GameWorld world = DependencyManager.get("world");
            world.getSettings().setName(newValue);
        });

    }
}
