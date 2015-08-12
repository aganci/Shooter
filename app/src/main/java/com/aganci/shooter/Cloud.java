package com.aganci.shooter;

import android.graphics.Bitmap;

import com.aganci.game.RandomNumberGenerator;

public class Cloud {
    private final Bitmap bitmap;
    private float x = 0;
    private float y = 0;
    private long velocity = 10;

    public Cloud(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void renderTo(Screen screen, long delta) {
        if (x < -bitmap.getWidth()) {
            return;
        }

        screen.getCanvas().drawBitmap(bitmap, x, y, screen.getPaint());

        x -= delta / velocity;
    }

    public void randomize(int width, int height) {
        int newX = RandomNumberGenerator.getRandIntBetween(width, width + width - bitmap.getWidth());
        int newY = RandomNumberGenerator.getRandIntBetween(0, height - bitmap.getHeight());
        this.x = newX;
        this.y = newY;
    }
}
