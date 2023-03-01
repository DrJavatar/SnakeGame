package com.game.ui.canvas;

import com.game.engine.world.GameWorld;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GameCanvas extends Canvas implements GameSkin {

    @Override
    public void drawGame() {
        GraphicsContext gc = getGraphicsContext2D();
    }

    @Override
    public void drawBody(double x, double y) {
        GraphicsContext gc = getGraphicsContext2D();

    }

    @Override
    public void drawHead(double x, double y) {
        GraphicsContext gc = getGraphicsContext2D();

    }

    @Override
    public void drawTail(double x, double y) {
        GraphicsContext gc = getGraphicsContext2D();

    }
}
