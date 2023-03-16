package com.game.engine;

public class GameSettings {

    private Difficulty difficulty = Difficulty.EASY;

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public static enum Difficulty {
        EASY(1, 0),
        NORMAL(2, 20),
        HARD(3, 50),
        IMPOSSIBLE(4, 75);

        private int snakeSpeed;
        private int objectGenerationRate;

        Difficulty(int snakeSpeed, int objectGenerationRate) {
            this.snakeSpeed = snakeSpeed;
            this.objectGenerationRate = objectGenerationRate;
        }

        public int getSnakeSpeed() {
            return snakeSpeed;
        }

        public int getObjectGenerationRate() {
            return objectGenerationRate;
        }
    }
}
