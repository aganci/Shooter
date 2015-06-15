package com.aganci.shooter;

import android.graphics.Rect;

public class Bird {

    public static Bird createBlue(Assets assets) {
        return new Bird(assets, "blue-calm-bird-", 10, 180);
    }

    public static Bird createGreen(Assets assets) {
        return new Bird(assets, "happy-green-yellow-bird-", 7, 100);
    }

    private final Sprite sprite;
    int velocity;

    public Bird(Assets assets, String baseName, int velocity, int delay) {
        this.velocity = velocity;
        sprite = new Sprite(baseName, 4, assets, delay);
    }

    public void renderTo(Screen screen, long delta) {
        if (sprite.getX() > screen.width()) {
            return;
        }

        sprite.update(delta);
        sprite.renderTo(screen);

        sprite.incrementPositionBy((int) delta / velocity, 0);
    }

    public void onStart(int width, int height) {
        randomize(width, height);
    }

    public void randomize(int width, int height) {
        int y = RandomNumberGenerator.getRandIntBetween(0, height - sprite.height());
        int x = -RandomNumberGenerator.getRandIntBetween(sprite.width(), sprite.width() + width);
        int currentFrame = RandomNumberGenerator.getRandIntBetween(0, sprite.frameCount() - 1);
        sprite.position(x, y);
        sprite.currentFrame(currentFrame);
    }

    public boolean hasHit(float x, float y) {
        return sprite.hasHit(x, y);
    }

    public int width() {
        return sprite.width();
    }

    public void position(int x, int y) {
        sprite.position(x, y);
    }
}
