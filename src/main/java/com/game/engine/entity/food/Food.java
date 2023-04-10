package com.game.engine.entity.food;

import com.game.engine.entity.Entity;
import com.game.engine.entity.snake.Snake;
import com.game.engine.entity.snake.SnakeBody;
import com.game.engine.world.GameWorld;
import com.game.utilties.Vector2d;

public class Food extends Entity {

    private boolean isEaten;

    public Food(double x, double y) {
        super(new Vector2d(x, y));
    }

    public boolean isEaten() {
        return isEaten;
    }

    public void setEaten(boolean eaten) {
        isEaten = eaten;
    }

    @Override
    public void onTick(GameWorld world) {
        Snake snake = world.getSnake();
        if(snake.intersects(this) && !isEaten) {
            isEaten = true;
            System.out.println("Eats food");
            snake.addBody(new SnakeBody(snake, this.getPosition()));
        }
    }
}
