package com.game.ui.game;

import com.game.engine.GameSettings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class NewGameModel {

    public final SimpleStringProperty playerName = new SimpleStringProperty();
    public final ObjectProperty<GameSettings.Difficulty> difficulty = new SimpleObjectProperty<>(GameSettings.Difficulty.EASY);

}
