package com.game.engine.entity.snake;

import com.game.engine.entity.Entity;
import com.game.utilties.Vector2d;

public class SnakeBody extends Entity {

    private SnakeBody next;
    private SnakeBody previous;

    public SnakeBody(Vector2d position) {
        super(position);
    }

    public boolean isHead() {
        return previous != null && next == null;
    }

    public boolean isTail() {
        return previous == null && next != null;
    }

    public SnakeBody getNext() {
        return next;
    }

    public SnakeBody getPrevious() {
        return previous;
    }

    @Override
    public boolean hasCollided(Entity entity) {
        return false;
    }
}
