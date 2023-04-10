package com.game.engine;

public class GameSettings {

    private Difficulty difficulty = Difficulty.EASY;

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public enum Difficulty {
        EASY(0),
        NORMAL(10),
        HARD(20),
        IMPOSSIBLE(30);

        private final int objectGenerationRate;

        Difficulty(int objectGenerationRate) {
            this.objectGenerationRate = objectGenerationRate;
        }

        public int getObjectGenerationRate() {
            return objectGenerationRate;
        }
    }
}
