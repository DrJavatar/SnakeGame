package com.game.engine.world;

import com.game.engine.GameScore;
import com.game.engine.GameSettings;
import com.game.engine.entity.Entity;
import com.game.engine.entity.food.Food;
import com.game.engine.entity.snake.Snake;
import com.game.engine.entity.snake.SnakeBody;
import com.game.engine.entity.wall.Wall;
import com.game.ui.canvas.GameCanvas;
import com.game.utilties.Vector2d;

import java.util.*;

import static com.game.ui.canvas.GameCanvas.*;

public class GameWorld implements Iterable<Entity> {

    public static final Random RANDOM = new Random();

    private Snake snake;

    private final List<Entity> entities;
    private final List<Entity> toAdd;
    private final List<Entity> toRemove;

    private final GameScore state;

    private final GameSettings settings;

    private boolean isGameOver;

    public GameWorld() {
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        state = new GameScore();
        settings = new GameSettings();
        isGameOver = false;
        entities = new ArrayList<>();
        toAdd = new ArrayList<>();
        toRemove = new ArrayList<>();
    }

    public void reset() {
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        entities.clear();
        toAdd.clear();
        toRemove.clear();
    }

    public void removeEntity(Entity entity) {
        toRemove.add(entity);
    }

    public boolean addEntity(Entity entity) {
        for (SnakeBody body : snake) {
            if(entity.intersects(body)) {
                return false;
            }
        }
        for (Entity value : entities) {
            if (value.intersects(entity)) {
                return false;
            }
        }
        toAdd.add(entity);
        return true;
    }

    public void placeEntities(GameCanvas canvas) {
        for (int i = 0; i < settings.getDifficulty().getObjectGenerationRate(); i++) {
            double x = RANDOM.nextDouble(WIDTH / BLOCK_SIZE) * BLOCK_SIZE;
            double y = RANDOM.nextDouble(HEIGHT / BLOCK_SIZE) * BLOCK_SIZE;
            addEntity(new Wall(new Vector2d(x, y), true));
        }

        double x = RANDOM.nextDouble(WIDTH / BLOCK_SIZE) * BLOCK_SIZE;
        double y = RANDOM.nextDouble(HEIGHT / BLOCK_SIZE) * BLOCK_SIZE;
        addEntity(new Food(x, y));
    }

    public void onTick(GameCanvas canvas) {

        entities.removeAll(toRemove);
        toRemove.clear();

        entities.addAll(toAdd);
        toAdd.clear();

        snake.onTick(this);
        for (Entity entity : entities) {
            entity.onTick(this);
        }
    }

    public GameScore getState() {
        return state;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public Snake getSnake() {
        return snake;
    }

    public GameSettings getSettings() {
        return settings;
    }

    @Override
    public Iterator<Entity> iterator() {
        return entities.iterator();
    }
}
