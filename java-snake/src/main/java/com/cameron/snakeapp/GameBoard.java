package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;

public class GameBoard {

    private double width;
    private double height;

    private Snake snake;
    private Food food;

    private boolean gameOver;

    public GameBoard(double width, double height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;

        this.gameOver = false;
        initBoard();
    }

    private void initBoard() {
        food = new Food();
        food.move(snake.getSnakeXPoints(), snake.getSnakeYPoints());
    }

    public void update() {
        snake.update();
        
        checkFoodGrabbed();     
        checkSelfHit();
        checkBorderHit();
    }

    private void checkFoodGrabbed() {
        if (snake.collisionCheckFood(food)) {
            snake.addSnakeBlock();
            food.move(snake.getSnakeXPoints(), snake.getSnakeYPoints());
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

    public void draw(GraphicsContext gc) {
        snake.draw(gc);
        food.draw(gc);
    }

    public boolean getGameOver() {
        return gameOver;
    }
    
}