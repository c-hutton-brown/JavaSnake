package com.cameron.snakeapp;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * 
 * Class to handle game config and starting the game
 * 
 * Author: Cameron Hutton-Brown
 */
public class JavaSnake extends Application {

    // Game screen width
    private final double WIDTH = 900;

    // Game screen height
    private final double HEIGHT = 900;

    // Size of a snake block
    private final double BLOCKSIZE = 30; 

    // Colour of the snake
    private final Color SNAKECOLOUR = Color.AQUA; 

    @Override
    public void start(Stage stage) {
        // Set title of the game window
        stage.setTitle("Java Snake");
        
        // Setup game window
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Create new canvas for game content
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        
        // Create new  GraphicsContext to draw on screen  
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        
        // Create new snake instance
        final Snake snake = new Snake(BLOCKSIZE, SNAKECOLOUR);

        // Create new GameBoard to handle game rules
        final GameBoard gameBoard = new GameBoard(WIDTH, HEIGHT, snake);

        // Create new GameLoop to run game
        final GameLoop gameLoop = new GameLoop(gameBoard, gc);

        // Check user input
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {

            // If A pressed move snake left
            if(key.getCode()==KeyCode.A) {
                snake.moveLeft();
            }

            // If W pressed move snake up
            if(key.getCode()==KeyCode.W) {
                snake.moveUp();
            }

            // If D pressed move snake right
            if(key.getCode()==KeyCode.D) {
                snake.moveRight();
            }

            // If S pressed move snake down
            if(key.getCode()==KeyCode.S) {
                snake.moveDown();
            }

            // If ESC pressed pause game
            if(key.getCode()==KeyCode.ESCAPE) {
                gameLoop.togglePause();
            }
        });

        // Start main game thread
        new Thread(gameLoop).start();

        // Show window
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
