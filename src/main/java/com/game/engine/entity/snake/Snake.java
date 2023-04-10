package com.game.engine.entity.snake;

import com.game.engine.entity.Entity;
import com.game.engine.world.GameWorld;
import com.game.utilties.Vector2d;
import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Snake extends Entity implements Iterable<SnakeBody> {

    private List<SnakeBody> snake;

    private Vector2d directionPos;

    public Snake(double x, double y) {
        super(new Vector2d(x, y));
        this.snake = new ArrayList<>();
        this.snake.add(new SnakeBody(this, getPosition()));
        this.directionPos = new Vector2d(0, 0);
    }

    public void addBody(SnakeBody body) {
        snake.add(body);
    }

    public Vector2d getDirectionPos() {
        return directionPos;
    }

    @Override
    public Vector2d getPosition() {
        if(snake.isEmpty()) {
            return Vector2d.ZERO;
        }
        return snake.get(0).getPosition();
    }

    @Override
    public void onTick(GameWorld world) {
        SnakeBody head = snake.get(0);
        Vector2d pos = head.getPosition();
        SnakeBody newHead = new SnakeBody(this, pos.add(directionPos));
        snake.add(0, newHead);
        snake.remove(snake.size() - 1);

        for (int i = 1; i < snake.size(); i++) {
            snake.get(i).onTick(world);
        }
    }

    @Override
    public Iterator<SnakeBody> iterator() {
        return snake.iterator();
    }
}
