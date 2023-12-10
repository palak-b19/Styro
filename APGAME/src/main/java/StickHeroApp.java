package com.stickheroap.stickheroap;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.IOException;

public class StickHeroApp extends Application {
    private AudioClip BackgroundMusic;
    private AudioClip stickGrowingSound;
    private Timeline stickSoundLoop;



    @Override
    public void start(Stage stage) throws IOException {
        try {
//            URL stickGrowingSoundUrl = getClass().getResource("/Images/blip.mp3");
//            stickGrowingSound = new AudioClip(stickGrowingSoundUrl.toString());
//            stickSoundLoop = new Timeline(
//                    new KeyFrame(Duration.millis(1), event -> {
//                        stickGrowingSound.play();
//                    })
//            );
//            stickSoundLoop.setCycleCount(Timeline.INDEFINITE);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home_page2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            HomeController controller = loader.getController();
//
//            String videoPath = getClass().getResource("/Images/GameAnimationFinal.mp4").toExternalForm();
//            System.out.println("Video Path: " + videoPath);
//            Media media = new Media(videoPath);
//            MediaPlayer mediaPlayer = new MediaPlayer(media);  // Fixed: Initialize mediaPlayer here
//
//            // Create a MediaView to display the video
//            MediaView mediaView = new MediaView(mediaPlayer);
//            mediaView.setFitWidth(600);
//            mediaView.setFitHeight(400);
//            ImageView backgroundImageView = new ImageView(new Image(getClass().getResource("AI_Generated_Image.jpg").toExternalForm()));
//
//            root.getChildren().add(mediaView);
//
//            //Set an event handler for when the video finishes
//            mediaPlayer.setOnEndOfMedia(() -> {
//                root.getChildren().add(backgroundImageView);
//                root.getChildren().add(btn);
//                //stage.show();
//                mediaPlayer.stop(); // Stop the video when transitioning to the game scene
//            });
//
//
//            mediaPlayer.play(); // Start playing the video


            controller.setStage(stage);

            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Result result=
                JUnitCore.runClasses(GameAnchorTest.class, GameSerializableTest.class, GameStickTest.class, GameStickWidthTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());

        launch(args);
    }
}