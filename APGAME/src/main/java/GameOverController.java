package com.stickheroap.stickheroap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverController extends BaseController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    public GameOverController() {
        super();
    }

    public GameOverController(Stage stage, Scene scene, Parent root) {
        super(stage, scene, root);
    }

    @FXML
    protected void retryGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("game_view2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void goHome(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("home_page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void draw() {}
}
