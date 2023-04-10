package com.game.engine.entity.food;

import com.game.engine.entity.Entity;
import com.game.engine.entity.snake.Snake;
import com.game.engine.entity.snake.SnakeBody;
import com.game.engine.world.GameWorld;
import com.game.utilties.Vector2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

import static com.game.ui.canvas.GameCanvas.*;

public class Food extends Entity {

    public static final Random RANDOM = new Random();

    public Food(double x, double y) {
        super(new Vector2d(x, y));
    }

    @Override
    public void onTick(GameWorld world) {
        Snake snake = world.getSnake();
        if(snake.intersects(this)) {
            snake.addBody(new SnakeBody(snake, this.getPosition()));
            world.removeEntity(this);
            world.getState().updateScore(1);
            double x, y;
            do {
                x = RANDOM.nextDouble(WIDTH / BLOCK_SIZE) * BLOCK_SIZE;
                y = RANDOM.nextDouble(HEIGHT / BLOCK_SIZE) * BLOCK_SIZE;
            } while(!world.addEntity(new Food(x, y)));
        }
    }

    @Override
    public void drawEntity(GraphicsContext gc) {
        gc.setFill(Color.YELLOW);
        gc.fillRect(position.getX(), position.getY(), BLOCK_SIZE, BLOCK_SIZE);
    }
}
