package com.example.apgame;
// BaseEntity.java
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BaseEntity extends UIElement {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    public BaseEntity(Stage stage, Scene scene, Parent root) {
        super(0, 0);
        this.stage = stage;
        this.scene = scene;
        this.root = root;
    }
}

