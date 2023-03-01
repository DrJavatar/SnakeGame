package com.game.engine;

import java.util.HashMap;
import java.util.Map;

public class GameState {

    private int score;

    private Map<String, Integer> scores;

    public GameState() {
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
