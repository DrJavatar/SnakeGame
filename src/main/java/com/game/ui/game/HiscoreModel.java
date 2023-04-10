package com.game.ui.game;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class HiscoreModel {
    public final SimpleIntegerProperty score = new SimpleIntegerProperty(0);

    public final SimpleListProperty<ScoreModel> scores = new SimpleListProperty<>(FXCollections.observableArrayList());

}
