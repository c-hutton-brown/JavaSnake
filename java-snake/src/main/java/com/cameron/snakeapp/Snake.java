package com.cameron.snakeapp;

import javafx.scene.paint.Color;
import java.util.ArrayList;

public class Snake {
    private int length = 3;
    private int direction = 0;
    private int speed = 100;

    private Color colour;
    private double opacity = 1.0;

    private ArrayList<SnakeBlock> snakeBlocks = new ArrayList<SnakeBlock>();

    public Snake() {
        
    } 

    public void update() {
        
    }
}