package com.game.engine.world.behaviour;

import com.game.engine.entity.food.Food;
import com.game.engine.entity.snake.Snake;
import com.game.engine.world.CollisionBehaviour;

public class GrowBehaviour implements CollisionBehaviour<Snake> {

    private Food food;

    public GrowBehaviour(Food food) {
        this.food = food;
    }

    @Override
    public boolean onCollision(Snake entity) {
        return false;
    }
}
