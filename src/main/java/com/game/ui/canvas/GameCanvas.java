package com.game.ui.canvas;

import com.game.di.DependencyManager;
import com.game.engine.entity.Entity;
import com.game.engine.entity.food.Food;
import com.game.engine.entity.snake.Snake;
import com.game.engine.entity.snake.SnakeBody;
import com.game.engine.world.GameWorld;
import com.game.utilties.Vector2d;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameCanvas extends AnimationTimer implements GameSkin {

    public final static double BLOCK_SIZE = 20.0;
    public final static double WIDTH = 800;
    public final static double HEIGHT = 591;

    private final Canvas canvas;
    private long lastTick = 0;

    private final double width;
    private final double height;

    public GameCanvas(double width, double height) {
        this.canvas = new Canvas(width, height);
        this.width = width;
        this.height = height;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void handle(long now) {
        if (now - lastTick > 100000000) {
            GraphicsContext gc = getGraphicsContext2D();
            GameWorld world = DependencyManager.get("world");
            lastTick = now;

            world.onTick(this);

            gc.clearRect(0, 0, width, height);
            if(world.isGameOver()) {
                gc.setFill(Color.WHITE);
                gc.fillText("Game Over!", width / 2, height / 2);
                stop();
            } else {
                drawGame(world);
            }
        }
    }

    public GraphicsContext getGraphicsContext2D() {
        return this.canvas.getGraphicsContext2D();
    }

    @Override
    public void drawGame(GameWorld world) {
        GraphicsContext gc = getGraphicsContext2D();

        Snake snake = world.getSnake();
        snake.drawEntity(gc);

        for (Entity entity : world) {
            entity.drawEntity(gc);
        }

    }
}
