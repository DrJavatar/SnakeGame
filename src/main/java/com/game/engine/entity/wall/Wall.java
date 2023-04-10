package com.game.engine.entity.wall;

import com.game.engine.entity.Entity;
import com.game.engine.entity.snake.Snake;
import com.game.engine.world.GameWorld;
import com.game.utilties.Vector2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static com.game.ui.canvas.GameCanvas.BLOCK_SIZE;

public class Wall extends Entity {

    public boolean isBreakable;

    public Wall(Vector2d position, boolean isBreakable) {
        super(position);
        this.isBreakable = isBreakable;
    }

    @Override
    public void onTick(GameWorld world) {
        Snake snake = world.getSnake();
        if(snake.intersects(this)) {
            world.setGameOver(true);
        }
    }

    @Override
    public void drawEntity(GraphicsContext gc) {
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(position.getX(), position.getY(), BLOCK_SIZE, BLOCK_SIZE);
    }
}
