package com.game.ui.canvas;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GameCanvas extends AnimationTimer implements GameSkin {

    private final Canvas canvas;
    private long lastTick = 0;

    private final double width;
    private final double height;

    public GameCanvas(double width, double height) {
        this.canvas = new Canvas(width, height);
        this.width = width;
        this.height = height;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    @Override
    public void handle(long now) {
        if (now - lastTick > 100000000) {
            GraphicsContext gc = getGraphicsContext2D();
            lastTick = now;
            gc.clearRect(0, 0, width, height);
            drawGame();
        }
    }

    public GraphicsContext getGraphicsContext2D() {
        return this.canvas.getGraphicsContext2D();
    }

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
