package com.game.engine.world;

import com.game.engine.entity.Entity;

@FunctionalInterface
public interface CollisionBehaviour<T extends Entity> {

    boolean onCollision(T entity);

}
