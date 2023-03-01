package com.game.engine.entity;

import com.game.utilties.Vector2d;

public abstract class Entity implements SolidEntity, Locatable {

    protected Vector2d position;
    protected Direction direction;

    public Entity(Vector2d position) {
        this.position = position;
        this.direction = Direction.NORTH;
    }



    @Override
    public Vector2d getPosition() {
        return this.position;
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }
}
