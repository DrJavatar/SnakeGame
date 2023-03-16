package com.game.engine.world;

import com.game.engine.GameScore;
import com.game.engine.GameSettings;
import com.game.engine.entity.Entity;
import com.game.engine.entity.food.Food;
import com.game.engine.entity.snake.Snake;
import com.game.utilties.Vector2d;

import java.util.HashMap;
import java.util.Map;

public class GameWorld {

    private Collision collision;

    private Map<Vector2d, Entity> entities;

    private Snake snake;

    private GameScore state;

    private GameSettings settings;

    public GameWorld() {
        collision = new Collision(this);
        entities = new HashMap<>();
        snake = new Snake(5, 5);
        state = new GameScore();
        settings = new GameSettings();
    }

    public Food newFood(double x, double y) {
        return new Food(x, y);
    }

    public Snake newSnake(double x, double y) {
        return new Snake(x, y);
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
