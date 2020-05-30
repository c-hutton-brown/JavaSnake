package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameLoop implements Runnable {
    private boolean running;
    private GameBoard gameBoard;
    private GraphicsContext gc;

    private final int FPS = 10;
    private final int optim_time = 1000 / FPS;

    private boolean paused = false;

    public GameLoop(GameBoard gameBoard, GraphicsContext gc) {
        this.running = true;
        this.gameBoard = gameBoard;
        this.gc = gc;
    }

    public void run() {
        long startTime;    
        long delta;      
        int waitTime;

        while (running) {
            startTime = System.currentTimeMillis();

            if (!paused) {
                update();
            }
            draw();

            delta = System.currentTimeMillis() - startTime;
            waitTime = (int)(optim_time - delta);
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
            }   
        }

    }

    public void togglePause() {
        paused ^= true;
    }

    private void draw() {
        // Clear the canvas
        gc.setFill( new Color(0, 0, 0, 1.0) );
        gc.fillRect(0,0, 900, 900);

        gameBoard.draw(gc);
    }

    private void update() {
        gameBoard.update();
        if (gameBoard.getGameOver()) {
            running = false;
        }
    }
}