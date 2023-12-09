package com.stickheroap.stickheroap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BaseController extends Element {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    public BaseController() {
        super(0, 0);
    }

    public BaseController(Stage stage, Scene scene, Parent root) {
        super(0, 0);
        this.stage = stage;
        this.scene = scene;
        this.root = root;
    }
}