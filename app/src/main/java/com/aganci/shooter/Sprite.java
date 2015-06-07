package com.aganci.shooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Sprite {
    private int currentFrame;
    Bitmap[] bitmaps;
    long[] frameTime;
    private int frameCount;
    long currentTime = 0;

    public Sprite(String baseName, int frameCount, Assets assets) {
        this.frameCount = frameCount;
        bitmaps = new Bitmap[frameCount];
        for (int i = 0; i < frameCount; i++) {
            bitmaps[i] = assets.getBitmap(baseName + String.valueOf(i + 1));
        }
        frameTime = new long[frameCount];
        for (int i = 0; i < frameCount; i++) {
            frameTime[i] = (i + 1) * 100;
        }
        currentFrame = 0;
    }

    public void update(long delta) {
        currentTime += delta;

        if (currentTime >= frameTime[currentFrame]) {
            currentFrame += 1;
        }

        if (currentFrame == frameCount) {
            currentFrame = 0;
            currentTime = 0;
        }
    }

    public void renderTo(Screen screen) {
        Canvas canvas = screen.getCanvas();
        canvas.drawBitmap(bitmaps[currentFrame], 0, 0, screen.getPaint());
    }
}
