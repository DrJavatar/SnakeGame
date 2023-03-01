package com.game.engine.entity.food;

import com.game.engine.entity.Entity;
import com.game.engine.world.behaviour.GrowBehaviour;
import com.game.utilties.Vector2d;

public class Food extends Entity {
    public Food(double x, double y) {
        super(new Vector2d(x, y));
        super.behaviour = new GrowBehaviour(this);
    }
}
