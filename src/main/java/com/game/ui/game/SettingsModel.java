package com.game.ui.game;

import com.game.di.DependencyManager;
import com.game.engine.world.GameWorld;
import javafx.beans.property.SimpleStringProperty;

public class SettingsModel {

    public final SimpleStringProperty saveDirectory = new SimpleStringProperty("./");

    public SettingsModel() {

        saveDirectory.addListener((observable, oldValue, newValue) -> {
            GameWorld world = DependencyManager.get("world");
            world.getState().setDirectory(newValue);
        });

    }
}
