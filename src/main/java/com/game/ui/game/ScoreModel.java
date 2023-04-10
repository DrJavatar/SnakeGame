package com.game.ui.game;

import com.game.engine.GameSettings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class ScoreModel {

    private final SimpleStringProperty name;
    private final SimpleObjectProperty<GameSettings.Difficulty> difficulty;
    private final SimpleIntegerProperty score;

    public ScoreModel(String name, GameSettings.Difficulty difficulty, int score) {
        this.name = new SimpleStringProperty(name);
        this.difficulty = new SimpleObjectProperty<>(difficulty);
        this.score = new SimpleIntegerProperty(score);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public GameSettings.Difficulty getDifficulty() {
        return difficulty.get();
    }

    public SimpleObjectProperty<GameSettings.Difficulty> difficultyProperty() {
        return difficulty;
    }

    public int getScore() {
        return score.get();
    }

    public SimpleIntegerProperty scoreProperty() {
        return score;
    }
}
