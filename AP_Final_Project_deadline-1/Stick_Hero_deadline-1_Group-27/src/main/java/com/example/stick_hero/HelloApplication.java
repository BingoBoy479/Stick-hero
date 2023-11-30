package com.example.stick_hero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main_menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Stick Hero");
        stage.setWidth(569);
        stage.setHeight(398);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}