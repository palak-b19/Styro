package com.stickheroap.stickheroap;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

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
    @FXML
    private ImageView berry_encounter;

    private boolean hero_flipped_flag = false;
    private int distance = 0;
    private int prev_distance = 0;
    private int prev_prev_distance = 0;
    private Rectangle new_end_platform;
    private Rectangle new_stick;
    private ArrayList<Integer> platform_width = new ArrayList<Integer>();

    private double platformShiftSpeed = 5.0; // Adjust the speed as needed

    private void shiftPlatform(int distance) {

        score_count.setText(String.valueOf(Integer.parseInt(score_count.getText()) + 1));

        nextRound();

        prev_prev_distance = prev_distance;
        prev_distance = distance;

        TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(600), hero_img);
        translateTransition1.setByX(-1*distance);

        translateTransition1.play();

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.millis(600), stick_rect);
        translateTransition2.setByX(-1*distance);

        translateTransition2.play();

        TranslateTransition translateTransition3 = new TranslateTransition(Duration.millis(600), end_platform);
        translateTransition3.setByX(-1*distance);

        translateTransition3.play();

        TranslateTransition translateTransition4 = new TranslateTransition(Duration.millis(600), start_platform);
        translateTransition4.setByX(-1*distance);

        translateTransition4.play();


        TranslateTransition translateTransition6 = new TranslateTransition(Duration.millis(600), new_end_platform);

        translateTransition6.setByX(-1*distance);

        translateTransition6.play();

        translateTransition6.setOnFinished(e -> {

            new_stick.setX(172);
            new_stick.setY(251);

            stick_rect = new_stick;
            start_platform = end_platform;
            end_platform = new_end_platform;

            stick_extend_flag = true;
            stick_fall_flag = true;
            isMousePressed = false;
        });
    }

    public void nextRound() {
        new_end_platform = new Rectangle();
        new_stick = new Rectangle();

        new_end_platform.setFill(Color.BLACK);
        new_stick.setFill(Color.BLACK);

        new_end_platform.setLayoutX(0);
        new_end_platform.setLayoutY(0);

        Random random = new Random();

        new_end_platform.setWidth(random.nextInt(190) + 10);
        platform_width.add((int) new_end_platform.getWidth());
        new_end_platform.setHeight(250);
        new_end_platform.setX(272 + random.nextInt(50) + distance);
        new_end_platform.setY(end_platform.getY());

        new_stick.setLayoutX(0);
        new_stick.setLayoutY(0);
        new_stick.setHeight(0);
        new_stick.setWidth(3);

        System.out.println(new_end_platform.getX() + " " + new_end_platform.getY());

        main_pane.getChildren().addAll(new_stick, new_end_platform);
    }

    public GameController() {
        super();
        main_pane = new AnchorPane();
        main_pane.setLayoutX(0);
        main_pane.setLayoutY(0);
        button = new Button();
        main_pane.getChildren().add(button);
        score_count = new Text();
        start_platform = new Rectangle();
        start_platform.setLayoutX(0);
        start_platform.setLayoutY(0);
        end_platform = new Rectangle();
        end_platform.setLayoutX(0);
        end_platform.setLayoutY(0);
        berry_count = new Text();
        berry_encounter = new ImageView();

        hero_img = new ImageView();
        hero_img.setLayoutX(0);
        hero_img.setLayoutY(0);
        hero.setHero_image(hero_img);

        stick_rect = new Rectangle();
        stick_rect.setLayoutX(0);
        stick_rect.setLayoutY(0);

        stick.setStick_rect(stick_rect);
    }

    public GameController(Stage stage, Scene scene, Parent root) {
        super(stage, scene, root);
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
    Boolean stick_fall_flag = true;
    Boolean hero_walk_flag = false;
    Boolean hero_move_flag = false;
    Boolean platform_translate_flag = false;

    @FXML
    public void extendStick2(MouseEvent event) {
        if (stick_extend_flag) {
            if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                isMousePressed = true;
                extendStickVertically();
                Iterator iter = platform_width.iterator();
                try {
                    while (iter.hasNext())
                        System.out.println(iter.next());
                }
                catch (Exception e) {
                    int x = 1;
                }
            } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                isMousePressed = false;
            }
        }

    }

    Timeline timeline, timeline2, timeline3;

    private void extendStickVertically() {
        double initial_stick_height = stick_rect.getHeight();
        double initial_stick_y = stick_rect.getY();

        timeline = new Timeline(new KeyFrame(Duration.millis(30), e -> {
            stick_rect.setHeight(stick_rect.getHeight() + 5);
            stick_rect.setLayoutY(stick_rect.getLayoutY() - 5);
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        if (stick_extend_flag) {
            main_pane.setOnMouseReleased(event -> {
                timeline.stop();
                System.out.println("Extension Stopped");

                if (stick_fall_flag) {
                    stick_extend_flag = false;

                    fallStick();

                    stick_fall_flag = false;
                    hero_walk_flag = true;
                }
            });
        }
    }

    public void heroWalk() {
        distance = (int) (stick_rect.getHeight());

        Random random2 = new Random();
        if (random2.nextInt(20) < 10) {
            int berry_location = 172 + random2.nextInt((int) (distance - berry_encounter.getFitWidth()));
            berry_encounter.setX(berry_location);
            berry_encounter.setVisible(true);
        }

        boolean cherry_counted = false;

        hero_move_flag = true;
        if (distance >= end_platform.getX() - start_platform.getX() - start_platform.getWidth() && distance <= end_platform.getX() - start_platform.getX() - start_platform.getWidth() + end_platform.getWidth()) {
            TranslateTransition translateTransitionWin = new TranslateTransition(Duration.millis(2000), hero_img);
            translateTransitionWin.setByX(end_platform.getX() + end_platform.getWidth() - start_platform.getX() - start_platform.getWidth());
            translateTransitionWin.play();

            if (hero_move_flag && hero_flipped_flag && hero_img.getBoundsInParent().intersects(berry_encounter.getBoundsInParent()) && hero_flipped_flag && !cherry_counted && berry_encounter.isVisible()) {
                cherry_counted = true;
                setBerry_count(getBerry_count() + 1);
                berry_encounter.setVisible(false);
            }

            translateTransitionWin.setOnFinished(e -> {
                hero_move_flag = false;
                shiftPlatform((int) (end_platform.getX() + end_platform.getWidth() - start_platform.getX() - start_platform.getWidth()));
            });
        }
        else {
            TranslateTransition translateTransitionLose = new TranslateTransition(Duration.millis(2000), hero_img);
            translateTransitionLose.setByX(distance + 33);
            translateTransitionLose.play();

            translateTransitionLose.setOnFinished(e -> {
                TranslateTransition translateTransitionDown = new TranslateTransition(Duration.millis(500), hero_img);
                translateTransitionDown.setByY(start_platform.getHeight());
                hero_move_flag = false;
                translateTransitionDown.play();

                FXMLLoader game_revive_screen_loader = new FXMLLoader(getClass().getResource("game_revive.fxml"));
                try {
                    root = game_revive_screen_loader.load();

                    GameReviveController gameReviveController = game_revive_screen_loader.getController();
                    gameReviveController.setBerry_count(getBerry_count());
                    gameReviveController.setCurrent_score(Integer.parseInt(getScore_count()));

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                stage = (Stage) ((Node) main_pane).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            });
        }

    }

    @FXML
    public void flipHero(KeyEvent e) throws IOException {
        if (e.getCharacter().equals(" ")) {
            if (hero_move_flag && !hero_flipped_flag) {
                hero_img.setY(hero_img.getY() + 40);
                hero_img.setScaleY(-1);
                hero_flipped_flag = true;
            }
            else if (!hero_move_flag) {
                return;
            }
            else {
                hero_img.setY(hero_img.getY() - 40);
                hero_img.setScaleY(1);
                hero_flipped_flag = false;
            }
        }
    }

    public void fallStick() {
        System.out.println("fallStick");

        Rotate rotate = new Rotate(0, stick_rect.getX() + stick_rect.getWidth()/2, stick_rect.getY() + stick_rect.getHeight());
        stick_rect.getTransforms().add(rotate);

        timeline2 = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            if (rotate.getAngle() < 90) {
                rotate.setAngle(rotate.getAngle() + 2);
            }
            else {
                timeline2.stop();
                heroWalk();
            }
        }));

        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();

    }

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
    public Rectangle getStick_rect() {
        return stick_rect;
    }
    public AnchorPane getMain_pane() {
        return main_pane;
    }
}
