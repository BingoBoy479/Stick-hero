package com.example.stick_hero;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class StickTest implements Initializable {
    @FXML
    private Rectangle rec;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ScaleTransition st = new ScaleTransition();
        st.setNode(rec);
        st.setDuration(Duration.millis(1000));
        st.setByY(200);
        st.play();
    }
}
