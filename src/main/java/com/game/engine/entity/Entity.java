package com.game.engine.entity;

import com.game.engine.world.CollisionBehaviour;
import com.game.engine.world.GameWorld;
import com.game.utilties.Vector2d;

import static com.game.ui.canvas.GameCanvas.BLOCK_SIZE;

public abstract class Entity implements Locatable {

    protected Vector2d position;
    protected Direction direction;
    public Entity(Vector2d position) {
        this.position = position;
        this.direction = Direction.UP;
    }

    public abstract void onTick(GameWorld world);

    public boolean intersects(Entity other) {
        double thisRight = getPosition().getX() + BLOCK_SIZE;
        double thisBottom = getPosition().getY() + BLOCK_SIZE;
        double otherRight = other.getPosition().getX() + BLOCK_SIZE;
        double otherBottom = other.getPosition().getY() + BLOCK_SIZE;

        return (getPosition().getX() < otherRight && thisRight > other.getPosition().getX() && getPosition().getY() < otherBottom && thisBottom > other.getPosition().getY());
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
