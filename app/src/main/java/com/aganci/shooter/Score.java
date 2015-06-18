package com.aganci.shooter;

public class Score {
    GameText text;
    int score = 0;

    public Score(GameText text) {
        this.text = text;
    }

    public void increment(int value) {
        score += value;
    }

    public void renderTo(Screen screen) {
        text.renderTo(String.valueOf(score), 10, 10, screen);
    }
}
