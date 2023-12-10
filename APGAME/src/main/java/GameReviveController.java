package com.stickheroap.stickheroap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GameReviveController extends BaseController{
    @FXML
    private Button berry_button;
    private int current_score;
    private int berry_count;
    private final int REVIVE_BERRY_COUNT = 3;

    public GameReviveController() {
        super();
    }

    public GameReviveController(Stage stage, Scene scene, Parent root) {
        super(stage, scene, root);
    }

    @FXML
    protected void useBerries(ActionEvent event) throws IOException {
        FXMLLoader game_screen_loader = new FXMLLoader(getClass().getResource("game_view2.fxml"));
        root = game_screen_loader.load();

        if (getBerry_count() > REVIVE_BERRY_COUNT) {
            GameController gameController = game_screen_loader.getController();
            gameController.setBerry_count(getBerry_count() - REVIVE_BERRY_COUNT);
        }
        else {
            berry_button.setVisible(false);
        }

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void quitGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("home_page2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void draw() {

    }

    public int getCurrent_score() {
        return current_score;
    }

    public void setCurrent_score(int current_score) {
        this.current_score = current_score;
    }

    public void setBerry_count(int berry_count) {
        this.berry_count = berry_count;
    }

    public int getBerry_count() {
        return berry_count;
    }
}
