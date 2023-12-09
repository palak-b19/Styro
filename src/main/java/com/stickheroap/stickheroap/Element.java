package com.stickheroap.stickheroap;

public abstract class Element {
    private double x;
    private double y;
    private boolean visible;

    public Element(double x, double y) {
        this.x = x;
        this.y = y;
        this.visible = true;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public abstract void draw();
}
