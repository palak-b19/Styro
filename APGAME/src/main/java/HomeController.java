package com.stickheroap.stickheroap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;

public class HomeController extends BaseController{
    @FXML
    private AnchorPane root_pane;
    @FXML
    private Circle play_circle;
    @FXML
    private Group pause_group;
    @FXML
    private Group revive_group;

    private AudioClip backgroundMusic;

    public HomeController() {
        super();
    }

    public HomeController(Stage stage, Scene scene, Parent root) {
        super(stage, scene, root);
    }

    protected void setStage(Stage stage) {
        super.stage = stage;
    }

    @FXML
    protected void onPlayButtonClick(ActionEvent event) throws IOException {
        FXMLLoader game_screen_loader = new FXMLLoader(getClass().getResource("game_view2.fxml"));
        root = game_screen_loader.load();

        GameController gameController = game_screen_loader.getController();
//        gameController.setScore_count(0);

//        root = FXMLLoader.load(getClass().getResource("game_view2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        URL musicUrl = getClass().getResource("/com/stickheroap/stickheroap/Gamesong.mp3"); // Adjust the path to your music file
        backgroundMusic = new AudioClip(musicUrl.toString());
        backgroundMusic.setCycleCount(AudioClip.INDEFINITE);
        backgroundMusic.play();

//        System.out.println("Going to next Scene");
    }

    @FXML
    protected void onLeaderboardButtonClick(ActionEvent event) throws IOException {}

    @Override
    public void draw() {}

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
        root = FXMLLoader.load(getClass().getResource("home_page2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void loadGame(ActionEvent event) throws IOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serializedObject.txt"))) {
            SaveData save_object = (SaveData) inputStream.readObject();

            FXMLLoader game_screen_loader = new FXMLLoader(getClass().getResource("game_view2.fxml"));
            root = game_screen_loader.load();

            GameController gameController = game_screen_loader.getController();
            gameController.setScore_count(save_object.getScore());

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void shiftPlatform() {}

    private void addNewPlatform() {}

    @FXML
    protected void extendStick(ActionEvent event) throws IOException {}

    @FXML
    protected void pauseGame(ActionEvent event) throws IOException {
        FXMLLoader game_pause_screen_loader = new FXMLLoader(getClass().getResource("game_pause.fxml"));
        root = game_pause_screen_loader.load();

        GamePauseController gamePauseController = game_pause_screen_loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}