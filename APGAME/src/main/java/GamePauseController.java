package com.stickheroap.stickheroap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GamePauseController extends BaseController{
    private int current_score;

    public GamePauseController() {
        super();
    }

    public GamePauseController(Stage stage, Scene scene, Parent root) {
        super(stage, scene, root);
    }

    @FXML
    protected void resumeGame(ActionEvent event) throws IOException {
        FXMLLoader game_screen_loader = new FXMLLoader(getClass().getResource("game_view2.fxml"));
        root = game_screen_loader.load();

        GameController gameController = game_screen_loader.getController();
        gameController.setScore_count(getCurrent_score());

//        root = FXMLLoader.load(getClass().getResource("game_view2.fxml"));
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

    @FXML
    protected void saveGame(ActionEvent event) throws IOException {
        SaveData save = new SaveData(getCurrent_score());
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serializedObject.txt"))) {
            outputStream.writeObject(save);
            System.out.println("Object has been serialized.");
        } catch (Exception e) {
            e.printStackTrace();
        }

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
}
