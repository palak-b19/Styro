package com.example.apgame;

// Stick.java
import javafx.scene.shape.Line;
// Stick.java
import javafx.scene.shape.Line;

public class Stick extends BaseEntity {
    private Line stick;

    public Stick(Stage stage, Scene scene, Parent root, Line stick) {
        super(stage, scene, root);
        this.stick = stick;
    }

    @Override
    public void draw() {
        // Implementation
    }

    public void increaseStick() {
        // Implementation
    }

    public void fallStick() {
        // Implementation
    }
}


