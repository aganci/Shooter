package com.aganci.shooter;

import android.graphics.Bitmap;

public class Cloud {
    private final Bitmap bitmap;
    private float x = 0;
    private float y = 0;
    private long velocity = 10;

    public Cloud(Assets assets) {
        bitmap = assets.getBitmap("cloud-1");
    }

    public void renderTo(Screen screen, long delta) {
        screen.getCanvas().drawBitmap(bitmap, x, y, screen.getPaint());

        x -= delta / velocity;

        if (x < -bitmap.getWidth()) {
            randomize(screen.width(), screen.height());
        }
    }

    private void randomize(int width, int height) {
        int newX = RandomNumberGenerator.getRandIntBetween(width, width + width - bitmap.getWidth());
        int newY = RandomNumberGenerator.getRandIntBetween(0, height - bitmap.getHeight());
        this.x = newX;
        this.y = newY;
    }

    public void onStart(int width, int height) {
        randomize(width, height);
    }
}
