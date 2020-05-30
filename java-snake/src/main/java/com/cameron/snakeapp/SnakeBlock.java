package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SnakeBlock extends Sprite {

    public SnakeBlock(double x, double y, double blockSize) {
        super(x, y, blockSize, blockSize);
    }
    
    public SnakeBlock(double blockSize) {
        super(-blockSize, -blockSize, blockSize, blockSize);
    }

    public void draw(GraphicsContext gc, Color colour) {
        gc.setFill(colour);
        gc.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}