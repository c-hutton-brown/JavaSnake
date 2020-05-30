package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Food extends Sprite {

    public Food() {
        super(0, 0, 15, 15);
    }

    public void update() {

    }

    public void move(double[] xPoints, double[] yPoints) {
        Random rand = new Random();
        int ub = 900/30;

        int xPoint;
        int yPoint;

        while (true) {
            boolean invalidLocation = false;
            xPoint = rand.nextInt(ub) * 30;
            yPoint = rand.nextInt(ub) * 30; 

            for (int i = 0; i < xPoints.length; i++) {
                if (xPoints[i] == xPoint) {
                    if (yPoints[i] == yPoint) {
                        invalidLocation = true;
                        break;
                    }
                } 
            }
            if (!invalidLocation)
                break;
        }
        
        this.setX(xPoint + 7.5);
        this.setY(yPoint + 7.5);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
    
}