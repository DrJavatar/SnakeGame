package com.game.engine.world.behaviour;

import com.game.engine.entity.snake.Snake;
import com.game.engine.entity.snake.SnakeBody;
import com.game.engine.world.CollisionBehaviour;

public class GameOverBehaviour implements CollisionBehaviour<Snake> {

    private final SnakeBody snake;

    public GameOverBehaviour(SnakeBody snake) {
        this.snake = snake;
    }

    @Override
    public boolean onCollision(Snake entity) {
        return true;
    }
}
