package com.example.stick_hero;

import javafx.scene.shape.Rectangle;
/*
* making stick a separate object so that we can
* implement singleton design pattern in the future
* object contains a rectangle and getter setter for its height only
* */
/*
this is code for performing action at the press of a key
scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                // Increase the height by 10 pixels (adjust as needed)
                double newHeight = rectangle.getHeight() + 10;
                rectangle.setHeight(newHeight);
            }
        });
* */
public class Stick {
    private Rectangle stick_object;

}
