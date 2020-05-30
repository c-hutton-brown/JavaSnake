package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 
 * GameLoop class
 * 
 * Implements Runnable, start as thread
 * 
 * Author: Cameron Hutton-Brown
 */
public class GameLoop implements Runnable {

    // Game running
    private boolean running;
    
    // GameBoard to handle all game updates and render
    private final GameBoard gameBoard;

    // Graphics context to draw game content
    private final GraphicsContext gc;

    // FPS to run at (effects speed of snake)
    private final int FPS = 10;

    // How long each frame should run
    private final int optim_time = 1000 / FPS;

    // Check if game is paused
    private boolean paused = false;

    /**
     * GameLoop instance to run the game  
     * @param gameBoard GameBoard to update and render
     * @param gc GraphicsContext to draw content on game
     */
    public GameLoop(final GameBoard gameBoard, final GraphicsContext gc) {
        this.running = true;
        this.gameBoard = gameBoard;
        this.gc = gc;
    }

    /**
     * Method to run main loop
     */
    public void run() {
        // Start time of each frame
        long startTime;

        // Difference in time from start of frame to end
        long deltaTime;

        // How long to wait for frame to reach optimal time
        int waitTime;

        // Game Loop start
        while (running) {

            // Start time of frame
            startTime = System.currentTimeMillis();

            // Update and render game board
            update();
            draw();
            
            // Get change in time from start to now
            deltaTime = System.currentTimeMillis() - startTime;

            // Wait to reach optimal time needed for each frame
            waitTime = (int) (optim_time - deltaTime);
            try {
                Thread.sleep(waitTime);
            } catch (final InterruptedException e) {
                System.out.println(e);
            }   
        }

    }

    /**
     * Toggle if game is paused
     */
    public void togglePause() {
        paused ^= true;
    }

    /**
     * Method to render game window
     */
    private void draw() {
        // Clear the canvas
        gc.setFill(new Color(0, 0, 0, 1.0));
        gc.fillRect(0,0, 900, 900);

        gameBoard.draw(gc);
    }

    /**
     * Method to update game board
     */
    private void update() {
        if (!paused) {
            gameBoard.update();
        }

        if (gameBoard.getGameOver()) {
            running = false;
        }
    }
}