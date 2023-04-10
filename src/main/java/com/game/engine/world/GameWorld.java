package com.game.engine.world;

import com.game.engine.GameScore;
import com.game.engine.GameSettings;
import com.game.engine.entity.Entity;
import com.game.engine.entity.food.Food;
import com.game.engine.entity.snake.Snake;
import com.game.engine.entity.wall.Wall;
import com.game.ui.canvas.GameCanvas;
import com.game.utilties.Vector2d;

import java.util.*;

import static com.game.ui.canvas.GameCanvas.*;

public class GameWorld implements Iterable<Entity> {

    public static final Random RANDOM = new Random();

    private final Snake snake;

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

    public void removeEntity(Entity entity) {
        toRemove.add(entity);
    }

    public boolean addEntity(Entity entity) {
        for (Entity value : entities) {
            if(value.intersects(entity)) {
                return false;
            }
        }
        toAdd.add(entity);
        return true;
    }

    public void placeEntities(GameCanvas canvas) {
        /*// Place walls on the top and bottom edges
        for (double x = 0; x < WIDTH; x += BLOCK_SIZE) {
            entities.add(new Wall(new Vector2d(x, 0), false));
            entities.add(new Wall(new Vector2d(x, HEIGHT - BLOCK_SIZE), false));
        }
        // Place walls on the left and right edges
        for (double y = BLOCK_SIZE; y < HEIGHT - BLOCK_SIZE; y += BLOCK_SIZE) {
            entities.add(new Wall(new Vector2d(0, y), false));
            entities.add(new Wall(new Vector2d(WIDTH - BLOCK_SIZE, y), false));
        }*/

        for(int i = 0; i < settings.getDifficulty().getObjectGenerationRate(); i++) {
            double x = RANDOM.nextDouble(WIDTH / BLOCK_SIZE) * BLOCK_SIZE;
            double y = RANDOM.nextDouble(HEIGHT / BLOCK_SIZE) * BLOCK_SIZE;
            addEntity(new Wall(new Vector2d(x, y), true));
        }

        addEntity(new Food(50, 50));
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
