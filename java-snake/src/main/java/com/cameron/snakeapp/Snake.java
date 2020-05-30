package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 * 
 * Class to control attributes of the snake and movement, and to check for collision  
 * 
 *  Author: Cameron Hutton-Brown
 */
public class Snake {
    // Direction of snake
    // {0 - left} {1 - up} {2 - right} {3 - down}
    private int direction = 2;

    // Start length of snake
    private final int startLength = 3;

    // Colour of snake
    private final Color colour;

    // Size of snake block
    private final double blockSize;

    // ArrayList of snake blocks to make up snake body
    private final ArrayList<SnakeBlock> snakeBlocks = new ArrayList<SnakeBlock>();

    /**
     * Snake instance with a default colour
     * @param blockSize Size of a snake block
     */
    public Snake(final double blockSize) {
        this.blockSize = blockSize;

        // Set default colour
        this.colour = Color.GREEN;

        // Initialise snake
        initSnake();
    }

    /**
     * Snake instance with a set colour
     * @param blockSize Size of a snake block
     * @param colour Colour of snake
     */
    public Snake(final double blockSize, final Color colour) {
        this.blockSize = blockSize;
        this.colour = colour;

        // Initialise snake
        initSnake();
    }

    /**
     * Method to update snake body location and move in specified direction 
     */
    public void update() {
        // Move all snake body parts to next position 
        for (int i = snakeBlocks.size() - 1; i >= 1; i--) {
            snakeBlocks.get(i).setX(snakeBlocks.get(i - 1).getX());
            snakeBlocks.get(i).setY(snakeBlocks.get(i - 1).getY());
        }

        // Move snake head in correct direction
        switch (this.direction) {
            case 0:
                // Move left
                snakeBlocks.get(0).setX(snakeBlocks.get(0).getX() - blockSize);
                break;
            case 1:
                // Move up
                snakeBlocks.get(0).setY(snakeBlocks.get(0).getY() - blockSize);
                break;
            case 2:
                // Move right
                snakeBlocks.get(0).setX(snakeBlocks.get(0).getX() + blockSize);
                break;
            case 3:
                // Move down
                snakeBlocks.get(0).setY(snakeBlocks.get(0).getY() + blockSize);
                break;
        }
    }

    /**
     * Method to render all snake blocks
     * @param gc GraphicsContext to draw game content
     */
    public void draw(final GraphicsContext gc) {
        int bodyLength = snakeBlocks.size();
        // Draw each snake body part
        for (int i = 0; i < bodyLength; i++) {
            
            // Calculate multiplier for index to find alpha value
            double alphaMulitiplier = 1.0/snakeBlocks.size();
            
            // Find alpha value to assign this block
            double alpha = (bodyLength - i) * alphaMulitiplier;

            // Draw block
            snakeBlocks.get(i).draw(gc, alpha, this.colour);
        }
    }

    /**
     * Method to move snake left
     */
    public void moveLeft() {
        this.direction = 0;
    }

    /**
     * Method to move snake up
     */
    public void moveUp() {
        this.direction = 1;
    }

    /**
     * Method to move snake right
     */
    public void moveRight() {
        this.direction = 2;
    }

    /**
     * Method to move snake down
     */
    public void moveDown() {
        this.direction = 3;
    }

    /**
     * Method to add snake block with a location
     * @param x X position to add snake block (top left position)
     * @param y Y position to add snake block (top left position)
     */
    public void addSnakeBlock(final double x, final double y) {
        snakeBlocks.add(new SnakeBlock(x, y, blockSize));
    }

    /**
     * Method to add new snake block
     */
    public void addSnakeBlock() {
        snakeBlocks.add(new SnakeBlock(blockSize));
    }

    /**
     * Check for collision with a food object
     * @param food Food instance to check for collision
     * @return Returns true if snake head collides with food
     */
    public boolean collisionCheckFood(final Food food) {
        // Check if snake head collides with food
        if (snakeBlocks.get(0).intersects(food)) {
            return true;
        }
        return false;
    }

    /**
     * Check for snake head colliding with body
     * @return Returns true if snake head collides with body
     */
    public boolean collisionCheckSelf() {
        // Check if body blocks intersect with snake head
        for (int i = 1; i < snakeBlocks.size(); i++) {
            if (snakeBlocks.get(0).intersects(snakeBlocks.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check for collision between snake head and border of screen
     * @param width Width of game area
     * @param height Height of game area
     * @return Returns true if snake head collides with border of playable area
     */
    public boolean collisionCheckBorder(final double width, final double height) {
        // Check if snake head goes past border
        if ((snakeBlocks.get(0).getX() >= width) || (snakeBlocks.get(0).getX() < 0)
                || (snakeBlocks.get(0).getY() >= height) || (snakeBlocks.get(0).getY() < 0)) {
            return true;
        }
        return false;
    }

    /**
     * Returns all X points of the snake body
     * @return Double array of all X points of snake body
     */
    public double[] getSnakeXPoints() {
        // Get size of snake body array
        final int size = snakeBlocks.size();

        // Double array to hold all X points
        final double[] xPoints = new double[size];

        // Iterate through snake body blocks and add X position
        // to Double array
        for (int i = 0; i < size; i++) {
            xPoints[i] = snakeBlocks.get(i).getX();
        }

        return xPoints;
    }

    /** 
     * Returns all Y points of the snake body
     * @return Double array of all Y points of snake body
     */
    public double[] getSnakeYPoints() {
        // Get size of snake body array
        final int size = snakeBlocks.size();

        // Double array to hold all Y points
        final double[] yPoints = new double[size];
        
        // Iterate through snake body blocks and add Y position
        // to Double array
        for (int i = 0; i < size; i++) {
            yPoints[i] = snakeBlocks.get(i).getY();
        }

        return yPoints;
    }

    /**
     * Returns size of a snake block
     * @return Size of the snake block
     */
    public double getBlockSize() {
        return blockSize;
    }

    /**
     * Method to initialise the snake body
     */
    private void initSnake() {
        for (int i = startLength - 1; i > -1; i--) {
            addSnakeBlock(blockSize * (i + 1), blockSize * startLength);
        }
    }
}