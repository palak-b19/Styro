package com.stickheroap.stickheroap;

import java.io.Serializable;

public class SaveData implements Serializable {
    private int score;

    public SaveData(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
