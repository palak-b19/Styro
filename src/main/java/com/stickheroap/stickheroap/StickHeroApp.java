package com.stickheroap.stickheroap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class StickHeroApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
//            Parent root_fxml = FXMLLoader.load(StickHeroApp.class.getResource("home_page.fxml"));
//            Scene scene = new Scene(root_fxml);

//            AnchorPane root_pane;

//            Group root = new Group();
//            Scene scene = new Scene(root, 600, 400);
//
//            stage.setTitle("StickHero - HomeScreen");
//            stage.setWidth(600);
//            stage.setHeight(400);
//            stage.setResizable(false);
//            stage.setFullScreen(true);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("home_page2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            HomeController controller = loader.getController();
            controller.setStage(stage);

            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}