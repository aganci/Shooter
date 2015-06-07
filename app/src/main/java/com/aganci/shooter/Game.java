package com.aganci.shooter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Game {
    private Paint paint = new Paint();
    private Rect textBounds = new Rect();
    Bird[] birds;

    public Game(Assets assets) {
        birds = new Bird[50];
        for (int i = 0; i < 50; i++) {
            birds[i] = new Bird(assets);
        }
    }

    public void renderTo(Screen screen, long delta) {
        for(Bird bird : birds) {
            bird.renderTo(screen, delta);
        }
    }

    public void onStart(int width, int height) {
        for(Bird bird : birds) {
            bird.onStart(width, height);
        }
    }
}
