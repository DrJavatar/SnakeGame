package com.game.engine.entity.snake;

import com.game.engine.entity.Entity;
import com.game.engine.world.GameWorld;
import com.game.utilties.Vector2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.game.ui.canvas.GameCanvas.*;

public class Snake extends Entity implements Iterable<SnakeBody> {

    private final List<SnakeBody> snake;

    private final Vector2d directionPos;

    public Snake(double x, double y) {
        super(new Vector2d(x, y));
        this.snake = new ArrayList<>();
        this.snake.add(new SnakeBody(this, position));
        this.directionPos = Vector2d.ZERO;
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
        Vector2d newPos = pos.add(direction.getDx() * BLOCK_SIZE, direction.getDy() * BLOCK_SIZE);

        double x = newPos.getX();
        double y = newPos.getY();
        double newX = x < 0 ? WIDTH : x > WIDTH ? 0 : x;
        double newY = y < 0 ? HEIGHT : y > HEIGHT ? 0 : y;
        newPos.set(newX, newY);

        SnakeBody newHead = new SnakeBody(this, newPos);
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

    @Override
    public void drawEntity(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        for (SnakeBody body : snake) {
            Vector2d pos = body.getPosition();
            gc.fillRect(pos.getX(), pos.getY(), BLOCK_SIZE, BLOCK_SIZE);
        }
    }
}
