package com.cameron.snakeapp;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

public class GameBoard {

    private double width = 900;
    private double height = 900;

    private Snake snake;
    private Food food;

    private boolean gameOver;

    public GameBoard(int cellSize, Snake snake) {

        this.gameOver = false;
        this.snake = snake;

        initBoard();
    }


    private void initBoard() {
        food = new Food();
        food.move(getSnakeXPoints(), getSnakeYPoints());
    }

    public void update() {
        snake.update();
        
        checkFoodGrabbed();     
        checkSelfHit();
        checkBorderHit();
    }

    private void checkFoodGrabbed() {
        if (snake.collisionCheckFood(food)) {
            snake.addSnakeBlock(0, 0);
            food.move(getSnakeXPoints(), getSnakeYPoints());
        }
    }

    private void checkSelfHit() {
        if (snake.collisionCheckSelf()) {
            endGame();
        }
    }

    private void checkBorderHit() {
        if (snake.collisionCheckBorder(width, height)) {
            endGame();
        }
    }

    private void endGame() {
        gameOver = true;
    }

    private double[] getSnakeXPoints() {
        ArrayList<SnakeBlock> snakeBlocks = snake.getSnakePoints();

        int size = snakeBlocks.size();
        double[] xPoints = new double[size];
       
        for (int i = 0; i < size; i++) {
            xPoints[i] = snakeBlocks.get(i).getX();
        }

        return xPoints;
    }

    
    private double[] getSnakeYPoints() {
        ArrayList<SnakeBlock> snakeBlocks = snake.getSnakePoints();

        int size = snakeBlocks.size();
        double[] yPoints = new double[size];
       
        for (int i = 0; i < size; i++) {
            yPoints[i] = snakeBlocks.get(i).getY();
        }

        return yPoints;
    }

    public void draw(GraphicsContext gc) {
        snake.draw(gc);
        food.draw(gc);
    }

    public boolean getGameOver() {
        return gameOver;
    }
    
}