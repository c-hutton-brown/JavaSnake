package com.cameron.snakeapp;

import javafx.geometry.Rectangle2D;

/**
 * 
 *  Sprite Class
 * 
 *  Author: Cameron Hutton-Brown
 */
public class Sprite {

    // X position of sprite
    private double x;

    // Y position of sprite
    private double y;
    
    // Width of sprite
    private double width;
    // Height of sprite
    private double height;

    /**
     * Sprite class to represent sprite objects added in game
     * @param x X Position of sprite (top left) 
     * @param y Y Position of spite (top left)
     * @param width Width of sprite
     * @param height Height of sprite
     */
    public Sprite(final double x, final double y, final double width, final double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns width of the sprite
     * 
     * @return Width of the sprite
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Sets the width of the sprite
     * 
     * @param width New width of the sprite
     */
    public void setWidth(final double width) {
        this.width = width;
    }

    /**
     * Returns the height of the sprite
     * 
     * @return Height of the sprite
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Sets the height of the sprite
     * 
     * @param height New height of the sprite
     */
    public void setHeight(final double height) {
        this.height = height;
    }

    /**
     * Returns the X position of the sprite (top left point)
     * 
     * @return X position of the sprite (top left point)
     */
    public double getX() {
        return this.x;
    }

    /**
     * Sets the X position of the sprite (top left point)
     * 
     * @param x New X position of the sprite (top left point)
     */
    public void setX(final double x) {
        this.x = x;
    }

    /**
     * Returns the Y position of the sprite (top left point)
     * 
     * @return Y position of the sprite (top left point)
     */
    public double getY() {
        return this.y;
    }

    /**
     * Sets the Y position of the sprite (top left point)
     * 
     * @param y New Y position of the sprite (top left point)
     */
    public void setY(final double y) {
        this.y = y;
    }

    /**
     * Returns the boundaries of the sprite instance
     * 
     * @return Rectangle2D instance of the sprite
     */
    public Rectangle2D getBoundary() {
        return new Rectangle2D(this.x, this.y, this.width, this.height);
    }

    /**
     * Check if this sprite instance is intersecting another given sprite
     * 
     * @param sprite Sprite to check for intersection
     * @return If sprites are intersecting then returns true
     */
    public boolean intersects(final Sprite sprite) {
        return sprite.getBoundary().intersects(this.getBoundary());
    }
}