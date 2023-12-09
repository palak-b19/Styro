package com.stickheroap.stickheroap;

import javafx.scene.image.ImageView;

public class Hero {
    // Singleton Design Pattern Implemented
    private static Hero hero = null;

    private static ImageView hero_image;

    private Hero() {}

    public static Hero getInstance() {
        if (hero == null) {
            hero = new Hero();
        }
        return hero;
    }
    private void displaceHero(boolean Success, int x) {}

    private void fallHero() {}

    public ImageView getHero_image() {
        return hero_image;
    }

    public void setHero_image(ImageView hero) {
        hero_image = hero;
    }
}
