package com.stickheroap.stickheroap;



import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Stick {
    // Singleton Design Pattern Implemented
    private static Stick stick = null;

    private static Rectangle stick_rect;

    private Stick() {}

    public static Stick getInstance() {
        if (stick == null) {
            stick = new Stick();
        }
        return stick;
    }

    public void extendStick() {
        stick_rect.setHeight(stick_rect.getHeight() + 5);
        stick_rect.setY(stick_rect.getY() - 5);
    }

    private void increaseStick() {}

    private void fallStick() {}

    public static Rectangle getStick_rect() {
        return stick_rect;
    }

    public static void setStick_rect(Rectangle stick) {
        stick_rect = stick;
        stick_rect.setY(241);
        stick_rect.setX(172);
        stick_rect.setHeight(11);
        stick_rect.setWidth(3);
    }
}
