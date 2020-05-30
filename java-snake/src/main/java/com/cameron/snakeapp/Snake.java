package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class Snake {
    private int length = 3;
    private int direction = 2;
    private double speed = 30;

    private Color colour;
    private double opacity = 1.0;

    private ArrayList<SnakeBlock> snakeBlocks = new ArrayList<SnakeBlock>();

    public Snake() {
        addSnakeBlock(90, 90);
        addSnakeBlock(60, 90);
        addSnakeBlock(30, 90);
    } 

    public void update() {
        for (int i = snakeBlocks.size() - 1; i >= 1; i--) {
            snakeBlocks.get(i).setX(snakeBlocks.get(i - 1).getX());
            snakeBlocks.get(i).setY(snakeBlocks.get(i - 1).getY());
        }

        switch (this.direction) {
            case 0:
                snakeBlocks.get(0).setX(snakeBlocks.get(0).getX() - speed);
                break;
            case 1:
                snakeBlocks.get(0).setY(snakeBlocks.get(0).getY() - speed); 
                break;
            case 2:
                snakeBlocks.get(0).setX(snakeBlocks.get(0).getX() + speed);
                break;
            case 3:
                snakeBlocks.get(0).setY(snakeBlocks.get(0).getY() + speed);
                break;
        }
    }   

    public void draw(GraphicsContext gc) {
        for (int i = 0; i < snakeBlocks.size(); i++) {
            snakeBlocks.get(i).draw(gc);
        }
    }

    public ArrayList<SnakeBlock> getSnakePoints() {
        return snakeBlocks;
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
        snakeBlocks.add(new SnakeBlock(x, y));
    }

    public boolean collisionCheckFood(Food food) {
        if (snakeBlocks.get(0).intersects(food)) {
            System.out.println("hi");
            return true;
        }
        return false;
    }

}