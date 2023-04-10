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
        NORMAL(20),
        HARD(50),
        IMPOSSIBLE(75);

        private final int objectGenerationRate;

        Difficulty(int objectGenerationRate) {
            this.objectGenerationRate = objectGenerationRate;
        }

        public int getObjectGenerationRate() {
            return objectGenerationRate;
        }
    }
}
