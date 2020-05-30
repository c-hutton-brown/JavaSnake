package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 
 *  SnakeBlock class
 * 
 *  Extends the sprite class to represent a snake block 
 * 
 *  Author: Cameron Hutton-Brown
 */
public class SnakeBlock extends Sprite {

    /**
     * SnakeBlock instance with a given position set
     * @param x X Position of sprite (top left) 
     * @param y Y Position of sprite (top left) 
     * @param blockSize Size of the snake block object
     */
    public SnakeBlock(double x, double y, double blockSize) {
        super(x, y, blockSize, blockSize);
    }
    
    /**
     * SnakeBlock instance with the sprite initially set off screen
     * @param blockSize X Position of sprite (top left) 
     */
    public SnakeBlock(double blockSize) {
        super(-blockSize, -blockSize, blockSize, blockSize);
    }

    /**
     * Method to draw snake block instance
     * @param gc GraphicsContext instance used to draw game content
     * @param colour Colour of the snake
     */
    public void draw(GraphicsContext gc, Color colour) {
        // Set fill then draw rectange
        gc.setFill(colour);
        gc.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}