package com.game.engine.world;

import com.game.engine.entity.Entity;

public class Collision {

    private GameWorld world;

    public Collision(GameWorld world) {
        this.world = world;
    }

    public boolean hasCollidedWith(Entity entity) {
        return false;
    }

}
