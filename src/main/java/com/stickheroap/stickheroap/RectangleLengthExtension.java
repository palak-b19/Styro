package com.stickheroap.stickheroap;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;


//stick - rectangle

public class RectangleLengthExtension extends Application {

    private double rectangleLength = 0.0;

    private AnchorPane root;
    private Rectangle rectangle;

    private static final int PILLAR_HEIGHT=180;

    private static final double shiftSpeed =120;

    private double firstPillarWidth =0.0;

    private double  secondPillarWidth=0.0;

    private Rectangle first,second;


    private double initialWidth = 50.0; // Initial width of the rectangle // pillar hegth

    private boolean stickExtended = false;
    private Timeline timeline;

    public boolean isGrowing = false;
    private boolean isGrowingFinished = false;

    private int frequency1=0;
    private int frequency2=0;

    @Override
    public void start(Stage primaryStage) {

        System.out.println("Application Started");
        root = new AnchorPane();
        Scene scene = new Scene(root, 600, 400);

        Rectangle rectangle1 = new Rectangle(100, 10, 50, 50);
        rectangle1.setFill(Color.RED);
        root.getChildren().add(rectangle1);

        rectangle = new Rectangle(172, 251, 3, 1);
        rectangle.setFill(Color.BLUE);

        root.getChildren().add(rectangle);

        // Set up a Timeline animation to extend the length of the rectangle
        timeline = new Timeline(
                new KeyFrame(Duration.millis(50), e -> extendRectangle())
        );
        timeline.setCycleCount(Animation.INDEFINITE);

        // Add mouse pressed and released event handlers
        root.setOnMousePressed(this::handleMousePressed);
        root.setOnMouseReleased(this::handleMouseReleased);

        primaryStage.setTitle("Rectangle Length Extension");
        primaryStage.setScene(scene);
        primaryStage.show();

//        timeline.play();
    }



    private void extendRectangle() {
        if (isGrowing) {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(8), event -> {
                        if(rectangle!=null) {
                            rectangle.setLayoutX(rectangle.getLayoutY() - 1);
                            rectangle.setHeight(rectangle.getHeight() + 1);
                        }
                    })
            );

            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }








//        double newHeight = rectangle.getHeight() + 5.0;
//        rectangle.setHeight(newHeight);
////        rectangle.setY(rectangle.getY() - 5.0);
//        rectangle.setY(rectangle.getY() - 1);

//        if (rectangle.getHeight() > initialWidth && !isGrowingFinished) {
//            isGrowingFinished = true;
//            shiftGamePane();
////        }
//    }
//        }



    private void handleMousePressed(MouseEvent event) {

        isGrowing=false;

        rectangleLength=rectangle.getHeight();

        rectangle.getTransforms().clear();

//        Rotate rotate = new Rotate(0,pivotx,pivoty)



            System.out.println("hello");
            timeline.play();
            stickExtended = true;
        }
//        else{
//            System.out.println("stick extended flag is set to true");
//        }




    private void handleMouseReleased(MouseEvent event) {
        isGrowing = false;

        rectangleLength = rectangle.getHeight();

        // Stop the timeline when the mouse is released
        timeline.stop();
    }

    private void shiftGamePane(){

        System.out.println("Shifting Game Pane...");
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void createRandomPillar(AnchorPane gameLayout) {
        Random random = new Random();
        double lowerWidth = 10;
        double upperWidth = 200;
        double PILLAR_WIDTH = random.nextDouble(upperWidth - lowerWidth) + lowerWidth;

        System.out.println("pillar width  "+ PILLAR_WIDTH);

        Rectangle pillar = new Rectangle(PILLAR_WIDTH, PILLAR_HEIGHT, Color.BLACK);

        double lowerLimit = (firstPillarWidth+first.getLayoutX());
        double upperLimit = gameLayout.getWidth()-700;

        if(upperLimit < lowerLimit){
            System.out.println(upperLimit + " " + lowerLimit);
        }
        double randomXCoordinate = random.nextDouble(upperLimit - lowerLimit) + lowerLimit;

        pillar.setLayoutX(randomXCoordinate);
        pillar.setLayoutY(330.0);
        gameLayout.getChildren().add(pillar);

        second = pillar;
        secondPillarWidth = PILLAR_WIDTH;
    }





}
