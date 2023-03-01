package com.game.engine.entity.snake;

import com.game.engine.entity.Entity;
import com.game.utilties.Vector2d;

public class Snake extends Entity {

    private SnakeBody previous;
    private SnakeBody tail;

    public Snake(double x, double y) {
        super(new Vector2d(x, y));
        this.tail = new SnakeBody(getPosition());
        this.previous = this.tail;
    }

    public void grow() {

    }

    @Override
    public boolean hasCollided(Entity entity) {
        return false;
    }
}
