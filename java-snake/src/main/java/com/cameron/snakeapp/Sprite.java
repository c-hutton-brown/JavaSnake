package com.cameron.snakeapp;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public class Sprite {

    private double x;
    private double y;
    private double width;
    private double height;

    public Sprite(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void draw(GraphicsContext gc) {

    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(x, y, width, height);
    }
 
    public boolean intersects(Sprite s)
    {
        return s.getBoundary().intersects(this.getBoundary());
    }
}