package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;

/**
 * 
 * GameBoard class to update and render sprites in game
 * 
 * Author: Cameron Hutton-Brown
 */
public class GameBoard {

    // Game screen width
    private final double width;

    // Game screen height
    private final double height;

    // Size of snake blocks
    private final double blockSize;

    // Snake instance used in game
    private final Snake snake;

    // Food instance used in game
    private Food food;

    // Boolean to alert game over
    private boolean gameOver;

    /**
     * GameBoard instance to set size of playable area and update/render sprites in game
     * @param width Screen width
     * @param height Screen height
     * @param snake Player controller snake
     */
    public GameBoard(final double width, final double height, final Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;

        // Get snake block size
        this.blockSize = snake.getBlockSize();

        // Set game is not over
        this.gameOver = false;

        // Initialise board
        initBoard();
    }

    /**
     * Method to update player controlled objects and check for any events
     */
    public void update() {
        // Update snake object
        snake.update();

        // Collision checks
        checkFoodGrabbed();
        checkSelfHit();
        checkBorderHit();
    }

    /**
     * Method to render sprites
     * @param gc GraphicsContext to draw game content
     */
    public void draw(final GraphicsContext gc) {
        // Draw snake
        snake.draw(gc);

        // Draw food
        food.draw(gc);
    }

    /**
     * Returns if game is over
     * @return True is game is over
     */
    public boolean getGameOver() {
        return gameOver;
    }

    /**
     * Method to initialise the game
     */
    private void initBoard() {
        // Create new food instance
        food = new Food(width, height, blockSize);

        // Randomise food location
        food.move(snake.getSnakeXPoints(), snake.getSnakeYPoints());
    }

    /**
     * Check if food has been collected by snake
     */
    private void checkFoodGrabbed() {
        // If food has been obtained
        if (snake.collisionCheckFood(food)) {
            // Add snake block
            snake.addSnakeBlock();
            
            // Move food to new location
            food.move(snake.getSnakeXPoints(), snake.getSnakeYPoints());
        }
    }

    /**
     * Check if snake head has collided with body
     */
    private void checkSelfHit() {
        // If snake has collided with self
        if (snake.collisionCheckSelf()) {
            // End the game
            endGame();
        }
    }

    /**
     * Check if the snake head has collided with the border of the screen
     */
    private void checkBorderHit() {
        // If snake has collided with border of screen
        if (snake.collisionCheckBorder(width, height)) {
            // End the game
            endGame();
        }
    }

    /**
     * Set game over
     */
    private void endGame() {
        gameOver = true;
    }
    
}