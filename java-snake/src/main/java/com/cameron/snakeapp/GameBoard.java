package com.cameron.snakeapp;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

public class GameBoard {

    private Snake snake;
    private Food food;

    private int cellSize;

    public GameBoard(int cellSize, Snake snake) {

        this.cellSize = cellSize;
        this.snake = snake;

        initBoard();
    }


    private void initBoard() {
        food = new Food();
        food.move(getSnakeXPoints(), getSnakeYPoints());
    }

    public void update() {
        snake.update();
        
        if (snake.collisionCheckFood(food)) {
            snake.addSnakeBlock(0, 0);
            food.move(getSnakeXPoints(), getSnakeYPoints());
        }
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
    
}