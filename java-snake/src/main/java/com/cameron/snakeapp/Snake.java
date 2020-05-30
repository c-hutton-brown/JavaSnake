package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class Snake {
    private int direction = 2;
    private int startLength = 3;

    private Color colour;
    private double blockSize;

    private ArrayList<SnakeBlock> snakeBlocks = new ArrayList<SnakeBlock>();

    public Snake(double blockSize) {
        this.blockSize = blockSize;
        this.colour = Color.GREEN;

        initSnake();
    } 

    public Snake(double blockSize, Color colour) {
        this.blockSize = blockSize;
        this.colour = colour;

        initSnake();
    } 

    private void initSnake() {
        for (int i = startLength - 1; i > -1; i--) {
            addSnakeBlock(blockSize * (i + 1), blockSize * startLength);
        }
    }

    public void update() {
        for (int i = snakeBlocks.size() - 1; i >= 1; i--) {
            snakeBlocks.get(i).setX(snakeBlocks.get(i - 1).getX());
            snakeBlocks.get(i).setY(snakeBlocks.get(i - 1).getY());
        }

        switch (this.direction) {
            case 0:
                snakeBlocks.get(0).setX(snakeBlocks.get(0).getX() - blockSize);
                break;
            case 1:
                snakeBlocks.get(0).setY(snakeBlocks.get(0).getY() - blockSize); 
                break;
            case 2:
                snakeBlocks.get(0).setX(snakeBlocks.get(0).getX() + blockSize);
                break;
            case 3:
                snakeBlocks.get(0).setY(snakeBlocks.get(0).getY() + blockSize);
                break;
        }
    }   

    public void draw(GraphicsContext gc) {
        for (int i = 0; i < snakeBlocks.size(); i++) {
            snakeBlocks.get(i).draw(gc, this.colour);
        }
    }
    public void moveLeft() {
        this.direction = 0;
    }

    public void moveUp() {
        this.direction = 1;
    }

    public void moveRight() {
        this.direction = 2;
    }

    public void moveDown() {
        this.direction = 3;
    }

    public void addSnakeBlock(double x, double y) {
        snakeBlocks.add(new SnakeBlock(x, y, blockSize));
    }

    public void addSnakeBlock() {
        snakeBlocks.add(new SnakeBlock(blockSize));
    }

    public boolean collisionCheckFood(Food food) {
        if (snakeBlocks.get(0).intersects(food)) {
            return true;
        }
        return false;
    }

    public boolean collisionCheckSelf() {
        for (int i = 1; i < snakeBlocks.size(); i++) {
            if (snakeBlocks.get(0).intersects(snakeBlocks.get(i))) {
                System.out.println("self collision");
                return true;
            }
        }
        return false;
    }

    public boolean collisionCheckBorder(double width, double height) {
        if ((snakeBlocks.get(0).getX() >= width)  || (snakeBlocks.get(0).getX() < 0) ||
            (snakeBlocks.get(0).getY() >= height) || (snakeBlocks.get(0).getY() < 0)) {
                return true;
        }
        return false;
    }

    public double[] getSnakeXPoints() {
        int size = snakeBlocks.size();
        double[] xPoints = new double[size];
       
        for (int i = 0; i < size; i++) {
            xPoints[i] = snakeBlocks.get(i).getX();
        }

        return xPoints;
    }
    
    public double[] getSnakeYPoints() {
        int size = snakeBlocks.size();
        double[] yPoints = new double[size];
       
        for (int i = 0; i < size; i++) {
            yPoints[i] = snakeBlocks.get(i).getY();
        }

        return yPoints;
    }
}