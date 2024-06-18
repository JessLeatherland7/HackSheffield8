package com.example.benji;

public class Score {
    private int currentScore;
    public Score() {
        this.currentScore = 0;
    }

    public int getCurrentScore() {
        return this.currentScore;
    }

    public void setCurrentScore(int s) {
        this.currentScore = s;
    }

    public void addToScore(int num) {
        this.currentScore += num;
    }

    public void resetScore() {
        this.currentScore = 0;
    }
}
