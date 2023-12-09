// Cherry.java
package com.stickheroap.stickheroap;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cherry extends Element {

    private static final double CHERRY_RADIUS = 10.0;
    private Circle cherry;

    public Cherry(double x, double y) {
        super(x, y);
        cherry = new Circle(CHERRY_RADIUS, Color.RED);
        cherry.setLayoutX(x);
        cherry.setLayoutY(y);
    }

    @Override
    public void draw() {
        // Add any draw logic if needed
    }

    public Circle getCherryNode() {
        return cherry;
    }
}
