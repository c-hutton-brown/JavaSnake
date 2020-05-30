package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * 
 *  Class to represent food for the snake to eat to obtain points
 *  
 *  Extends the sprite class
 * 
 *  Author: Cameron Hutton-Brown
 */
public class Food extends Sprite {

    // Size of original block size used by snake
    private final double blockSize;

    // Screen width
    private final double screenWidth;

    // Screen height
    private final double screenHeight;

    /**
     * Food instance where the food intance 
     * @param screenWidth Screen width used in game
     * @param screenHeight Screen height used in game
     * @param blockSize Size of the snake blocks
     */
    public Food(final double screenWidth, final double screenHeight, 
                final double blockSize) {
        super(0, 0, blockSize / 2, blockSize / 2);

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.blockSize = blockSize;
    }

    /**
     * Method to generate a random location for the food object, not allowing
     * the food to spawn where the snake is already located
     * @param xPoints X points not to spawn the food as snake is in these points
     * @param yPoints Y points not to spawn the food as snake is in these points
     */
    public void move(final double[] xPoints, final double[] yPoints) {
        // Create new random object
        final Random rand = new Random();

        // Get number of cells that exist in the game
        final int xUpper = (int) (this.screenWidth / this.blockSize);
        final int yUpper = (int) (this.screenHeight / this.blockSize);

        // Select a random point in the game board to place food
        double xPoint = rand.nextInt(xUpper) * this.blockSize;
        double yPoint = rand.nextInt(yUpper) * this.blockSize;

        // Check if location generated is valid
        boolean invalidLocation = true;
        while (invalidLocation) {
            invalidLocation = false;

            // Iterate through all X points used by the snake
            for (int i = 0; i < xPoints.length; i++) {
                // If snake already uses this X then also check Y
                if (xPoints[i] == xPoint) {
                    // If both X and Y points are in use then need to
                    // generate new point for food
                    if (yPoints[i] == yPoint) {
                        invalidLocation = true;
                        break;
                    }
                }
            }

            // If previous point for food was invalid, create new point
            if (invalidLocation) {
                xPoint = rand.nextInt(xUpper) * this.blockSize;
                yPoint = rand.nextInt(yUpper) * this.blockSize;
            }
        }

        // Once point has been found set this point as sprites new location 
        // and centre the sprite
        this.setX(xPoint + (this.blockSize / 4));
        this.setY(yPoint + (this.blockSize / 4));
    }

    /**
     * Method to draw food instance
     * @param gc GraphicsContext instance used to draw game content
     */
    public void draw(final GraphicsContext gc) {
        // Set fill then draw circle
        gc.setFill(Color.RED);
        gc.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
    
}