package com.example.apgame;


// GameOverMenu.java
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class GameOverMenu extends BaseEntity {
    @FXML
    private Rectangle retry_button;

    @FXML
    private Rectangle home_button;

    public GameOverMenu(Stage stage, Scene scene, Parent root) {
        super(stage, scene, root);
    }

    @FXML
    protected void retryGame(ActionEvent event) throws IOException {
        // Implementation
    }

    @FXML
    protected void goHome(ActionEvent event) throws IOException {
        // Implementation
    }

    @Override
    public void draw() {
        // Implementation
    }
}
