package com.example.apgame;

// HomeController.java
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class HomeController extends BaseEntity {
    @FXML
    private AnchorPane root_pane;
    @FXML
    private Circle play_circle;

    public HomeController(Stage stage, Scene scene, Parent root) {
        super(stage, scene, root);
    }

    @FXML
    protected void onPlayButtonClick(ActionEvent event) throws IOException {
        // Implementation
    }

    @FXML
    protected void onLeaderboardButtonClick(ActionEvent event) throws IOException {
        // Implementation
    }

    @Override
    public void draw() {
        // Implementation
    }
}
