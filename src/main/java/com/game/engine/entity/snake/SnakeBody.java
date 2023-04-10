package com.game.engine.entity.snake;

import com.game.engine.entity.Entity;
import com.game.engine.world.GameWorld;
import com.game.utilties.Vector2d;
import javafx.scene.canvas.GraphicsContext;

public class SnakeBody extends Entity {

    private final Snake parent;

    public SnakeBody(Snake parent, Vector2d position) {
        super(position);
        this.parent = parent;
    }

    @Override
    public void onTick(GameWorld world) {
        if(parent.intersects(this)) {
            world.setGameOver(true);
        }
    }

    @Override
    public void drawEntity(GraphicsContext gc) {

    }
}
