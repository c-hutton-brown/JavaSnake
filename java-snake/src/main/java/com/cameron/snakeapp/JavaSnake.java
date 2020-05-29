package com.cameron.snakeapp;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaSnake extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Java Snake");
    
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    
        Canvas canvas = new Canvas(500, 500);
        root.getChildren().add(canvas);
    
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        final Snake player = new Snake();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // Clear the canvas
                gc.setFill( new Color(0, 0, 0, 1.0) );
                gc.fillRect(0,0, 512,512);

                player.update();
            }
        }.start();
    
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
