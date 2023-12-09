package com.stickheroap.stickheroap;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GameController extends BaseController {
    private Stick stick = Stick.getInstance();
    private Hero hero = Hero.getInstance();
    private Timeline game;
    private Button button;

    @FXML
    private Rectangle start_platform;
    @FXML
    private Rectangle end_platform;
    @FXML
    private Text score_count;
    @FXML
    private AnchorPane main_pane;
    @FXML
    private Button pause_button;
    @FXML
    private Rectangle event_area;
    @FXML
    private Group pause_group;
    @FXML
    private Group pause_resume_button;
    @FXML
    private Group pause_quit_button;
    @FXML
    private Text berry_count;
    @FXML
    private Rectangle stick_rect;
    @FXML
    private ImageView hero_img;

    private double platformShiftSpeed = 5.0; // Adjust the speed as needed

    @FXML
    private void shiftPlatform() {
        start_platform.setLayoutX(start_platform.getLayoutX() - platformShiftSpeed);
        end_platform.setLayoutX(end_platform.getLayoutX() - platformShiftSpeed);
    }

    public GameController() {
        super();
        main_pane = new AnchorPane();
        button = new Button();
        main_pane.getChildren().add(button);
        score_count = new Text();
        berry_count = new Text();
        hero_img = new ImageView();
        hero.setHero_image(hero_img);
        stick_rect = new Rectangle();
//        stick_rect.setX(172);
//        stick_rect.setY(251);
//        stick_rect.setHeight(1);
//        stick_rect.setWidth(3);
        main_pane.getChildren().add(stick_rect);
        stick.setStick_rect(stick_rect);
//        startGame();
    }

    public GameController(Stage stage, Scene scene, Parent root) {
        super(stage, scene, root);
    }

//    private void shiftPlatform() {}

    private void addNewPlatform() {}

    @FXML
    protected void startExtension(MouseEvent event) throws IOException {
        game.play();
        System.out.println("Mouse Pressed!");
    }

    @FXML
    protected void pauseGame(ActionEvent event) throws IOException {
        FXMLLoader game_pause_screen_loader = new FXMLLoader(getClass().getResource("game_pause.fxml"));
        root = game_pause_screen_loader.load();

        GamePauseController gamePauseController = game_pause_screen_loader.getController();
        gamePauseController.setCurrent_score(Integer.parseInt(getScore_count()));
//        gameController.setScore_count(0);

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

    @Override
    public void draw() {}

    private boolean isMousePressed = false;

    Boolean stick_extend_flag = true;
    Boolean stick_fall_flag = false;
    Boolean hero_walk_flag = false;
    Boolean hero_flip_flag = false;
    Boolean platform_translate_flag = false;

    @FXML
    public void extendStick2(MouseEvent event) {
        if (stick_extend_flag) {
            if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                isMousePressed = true;
                extendStickVertically();
            } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                isMousePressed = false;
            }
        }

//        if (stick_fall_flag) {
//            fallStick();
//            stick_fall_flag = false;
//        }

    }

    Timeline timeline, timeline2;

    private void extendStickVertically() {
//        Timeline timeline = new Timeline();
//        KeyValue keyValue = new KeyValue(stick_rect.heightProperty(), stick_rect.getHeight() + 50);
//        KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue);
//        timeline.getKeyFrames().add(keyFrame);

        double initial_stick_height = stick_rect.getHeight();
        double initial_stick_y = stick_rect.getY();

        timeline = new Timeline(new KeyFrame(Duration.millis(30), e -> {
            stick_rect.setHeight(stick_rect.getHeight() + 5);
            stick_rect.setY(stick_rect.getY() - 5);
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        if (stick_extend_flag) {
            main_pane.setOnMouseReleased(event -> {
                timeline.stop();
                if (!stick_fall_flag) {
                    stick_extend_flag = false;
                    stick_fall_flag = true;
                    Rotate rotate = fallStick();
                    timeline2 = new Timeline(new KeyFrame(Duration.millis(500), new KeyValue(rotate.angleProperty(), rotate.getAngle() + 90)));
                    timeline2.setCycleCount(1);
                    timeline2.play();
                    stick_fall_flag = false;
                    hero_walk_flag = true;
                    heroWalk(initial_stick_y + initial_stick_height, stick_rect.getHeight() - initial_stick_height);
                }
            });
        }
    }

//    public void heroWalk(double startY, double distance) {
//        hero_img.setLayoutX(startY + distance);
//
//        for (double i = 0; i <= distance; i += 1) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            hero_img.setLayoutX(hero_img.getLayoutX() + 1);
//        }
//    }

    public void heroWalk(double startY, double distance) {
        Timeline walkTimeline = new Timeline();

        KeyFrame keyFrame = new KeyFrame(Duration.millis(10), e -> {
            hero_img.setLayoutX(hero_img.getLayoutX() + 1);
        });

        walkTimeline.getKeyFrames().add(keyFrame);
        walkTimeline.setCycleCount((int) Math.round(distance));

        walkTimeline.setOnFinished(event -> {
            // Hero walking animation finished
            hero_walk_flag = false;
            // Add logic to continue the game or perform other actions
        });

        walkTimeline.play();


    }

    public Rotate fallStick() {
        Rotate rotate = new Rotate(0, stick_rect.getX() + stick_rect.getWidth() / 2, stick_rect.getY() + stick_rect.getHeight());
        stick_rect.getTransforms().add(rotate);
        return rotate;
    }

//    public void startGame() {
//        game = new Timeline(new KeyFrame(Duration.millis(10), e -> gameplay()));
//        game.setCycleCount(Timeline.INDEFINITE);
//
//        main_pane.setOnMousePressed(event -> {
//            try {
//                startExtension(event);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        main_pane.setOnMouseReleased(event -> {
//            try {
//                stopExtension(event);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//
//    }

//    private void gameplay() {
//        stick.extendStick();
//    }

//    private void stopExtension(MouseEvent event) throws IOException {
//        game.stop();
//    }

    public String getScore_count() {
        return score_count.getText();
    }

    public void setScore_count(int score_count) {
        this.score_count.setText(String.valueOf(score_count));
    }

    public int getBerry_count() {
        return Integer.parseInt(berry_count.getText());
    }

    public void setBerry_count(int berry_count) {
        this.berry_count.setText(String.valueOf(berry_count));
    }
}
