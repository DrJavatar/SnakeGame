package com.game.engine.world;

import com.game.engine.GameScore;
import com.game.engine.entity.Entity;
import com.game.engine.entity.snake.Snake;
import com.game.utilties.Vector2d;

import java.util.HashMap;
import java.util.Map;

public class GameWorld {

    private Collision collision;

    private Map<Vector2d, Entity> entities;

    private Snake snake;

    private GameScore state;

    public GameWorld() {
        collision = new Collision(this);
        entities = new HashMap<>();
        snake = new Snake(5, 5);
        state = new GameScore();
    }

    public boolean addEntity(Entity entity) {
        if(!entities.containsKey(entity.getPosition())) {
            entities.put(entity.getPosition(), entity);
            return true;
        }
        return false;
    }

    public Entity removeEntity(Entity entity) {
        return entities.remove(entity.getPosition());
    }

    public boolean isGameOver() {
        return false;
    }

    public Snake getSnake() {
        return snake;
    }
}
