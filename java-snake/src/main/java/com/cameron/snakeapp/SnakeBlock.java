package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SnakeBlock extends Sprite {

    public SnakeBlock(double x, double y) {
        super(x, y, 30, 30);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}