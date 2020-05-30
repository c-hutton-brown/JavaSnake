package com.cameron.snakeapp;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaSnake extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Java Snake");
    
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    
        Canvas canvas = new Canvas(900, 900);
        root.getChildren().add(canvas);
    
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        Snake snake = new Snake();

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.A) {
                snake.moveLeft();
            }
            if(key.getCode()==KeyCode.W) {
                snake.moveUp();
            }
            if(key.getCode()==KeyCode.D) {
                snake.moveRight();
            }
            if(key.getCode()==KeyCode.S) {
                snake.moveDown();
            }
            if(key.getCode()==KeyCode.T) {
                snake.addSnakeBlock(0, 0);
            }
        });

        GameBoard gameBoard = new GameBoard(30, snake);
        GameLoop gameLoop = new GameLoop(gameBoard, gc);

        new Thread(gameLoop).start();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
