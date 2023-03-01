package com.game.engine.entity.snake;

import com.game.engine.entity.Entity;
import com.game.engine.world.CollisionBehaviour;
import com.game.engine.world.behaviour.GameOverBehaviour;
import com.game.utilties.Vector2d;

public class SnakeBody extends Entity {

    protected SnakeBody next;
    protected SnakeBody previous;

    public SnakeBody(Vector2d position) {
        super(position);
        super.behaviour = new GameOverBehaviour(this);
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
}
