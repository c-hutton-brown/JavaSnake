package com.cameron.snakeapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Food extends Sprite {

    private double blockSize;

    private double screenWidth;
    private double screenHeight;

    public Food(double screenWidth, double screenHeight, double blockSize) {
        super(0, 0, blockSize/2, blockSize/2);

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.blockSize = blockSize;
    }

    public void move(double[] xPoints, double[] yPoints) {
        Random rand = new Random();

        int xUpper = (int)(this.screenWidth/this.blockSize);
        int yUpper = (int)(this.screenHeight/this.blockSize);
        
        System.out.println(xUpper);

        double xPoint = rand.nextInt(xUpper) * this.blockSize;
        double yPoint = rand.nextInt(yUpper) * this.blockSize; 
        
        boolean invalidLocation = true;

        while (invalidLocation) {
            invalidLocation = false;

            for (int i = 0; i < xPoints.length; i++) {
                if (xPoints[i] == xPoint) {
                    if (yPoints[i] == yPoint) {
                        invalidLocation = true;
                        break;
                    }
                } 
            }

            if (invalidLocation) {
                xPoint = rand.nextInt(xUpper) * this.blockSize;
                yPoint = rand.nextInt(yUpper) * this.blockSize; 
            }
        }
        
        this.setX(xPoint + (this.blockSize/4));
        this.setY(yPoint + (this.blockSize/4));
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
    
}