package com.game.engine.entity.food;

import com.game.engine.entity.Entity;
import com.game.utilties.Vector2d;

public class Food extends Entity {

    public Food(double x, double y, double radius) {
        super(new Vector2d(x, y));
    }

    @Override
    public boolean hasCollided(Entity entity) {
        return false;
    }
}
