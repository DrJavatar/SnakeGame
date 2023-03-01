package com.game.engine.entity.snake;

import com.game.utilties.Vector2d;

public class Snake extends SnakeBody {

    public Snake(double x, double y) {
        super(new Vector2d(x, y));
        this.next = new SnakeBody(getPosition());
        this.previous = this.next;
    }
}
