package com.game.engine;

import java.util.HashMap;
import java.util.Map;

public class GameScore {

    private int score;

    private final Map<String, Integer> scores;

    public GameScore() {
        this.scores = new HashMap<>();
    }

    public void updateScore(int by) {
        this.score += by;
    }

    public void onGameEnd(String name) {
        scores.put(name, score);
    }

    public void save() {

    }

    public void load() {

    }

}
