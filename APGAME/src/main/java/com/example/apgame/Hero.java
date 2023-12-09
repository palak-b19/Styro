package com.example.apgame;
// Hero.java
import javafx.scene.image.ImageView;

public class Hero extends BaseEntity {
    private ImageView hero;

    public Hero(Stage stage, Scene scene, Parent root, ImageView hero) {
        super(stage, scene, root);
        this.hero = hero;
    }

    @Override
    public void draw() {
        // Implementation
    }

    public void displaceHero(boolean success) {
        // Implementation
    }

    public void fallHero() {
        // Implementation
    }
}

