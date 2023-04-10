package com.game.engine.entity;

import javafx.scene.canvas.GraphicsContext;

@FunctionalInterface
public interface EntitySkin {

    void drawEntity(GraphicsContext gc);

}
