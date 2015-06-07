package com.aganci.shooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Sprite {
    private int currentFrame;
    Bitmap[] bitmaps;
    long[] frameTime;
    private int frameCount;
    private int delay;
    long currentTime = 0;
    private int x = 0;
    private int y = 0;

    public Sprite(String baseName, int frameCount, Assets assets, int delay) {
        this.frameCount = frameCount;
        this.delay = delay;
        bitmaps = new Bitmap[frameCount];
        for (int i = 0; i < frameCount; i++) {
            bitmaps[i] = assets.getBitmap(baseName + String.valueOf(i + 1));
        }
        frameTime = new long[frameCount];
        for (int i = 0; i < frameCount; i++) {
            frameTime[i] = (i + 1) * delay;
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
        canvas.drawBitmap(bitmaps[currentFrame], x, y, screen.getPaint());
    }

    public int height() {
        return bitmaps[0].getHeight();
    }

    public int width() {
        return bitmaps[0].getWidth();
    }

    public void position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void incrementPositionBy(int stepX, int stepY) {
        x += stepX;
        y += stepY;
    }

    public int frameCount() {
        return frameCount;
    }

    public void currentFrame(int value) {
        this.currentFrame = value;
        currentTime = currentFrame * delay;
    }
}
