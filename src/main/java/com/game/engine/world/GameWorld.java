package com.game.engine.world;

import com.game.engine.GameScore;
import com.game.engine.GameSettings;
import com.game.engine.entity.food.Food;
import com.game.engine.entity.snake.Snake;
import com.game.ui.canvas.GameCanvas;

import java.util.Random;

import static com.game.ui.canvas.GameCanvas.BLOCK_SIZE;

public class GameWorld {

    private Snake snake;

    private Food currentFood;

    private GameScore state;

    private GameSettings settings;

    private boolean isGameOver;

    public GameWorld() {
        snake = new Snake(5, 5);
        currentFood = new Food(25, 25);
        state = new GameScore();
        settings = new GameSettings();
        isGameOver = false;
    }

    public void onTick(GameCanvas canvas) {

        if(currentFood.isEaten()) {
            state.updateScore(1);
            double x = new Random().nextDouble(canvas.getWidth() / BLOCK_SIZE) * BLOCK_SIZE;
            double y = new Random().nextDouble(canvas.getHeight() / BLOCK_SIZE) * BLOCK_SIZE;
            currentFood.getPosition().set(x, y);
            currentFood.setEaten(false);
        }

        snake.onTick(this);
        currentFood.onTick(this);
    }

    public GameScore getState() {
        return state;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getCurrentFood() {
        return currentFood;
    }
}
