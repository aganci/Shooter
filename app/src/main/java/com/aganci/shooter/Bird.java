package com.aganci.shooter;

import android.util.Log;

public class Bird {
    private final Sprite sprite;

    public Bird(Assets assets) {
        sprite = new Sprite("yellow-fat-bird-small-", 4, assets);
    }

    public void renderTo(Screen screen, long delta) {
        sprite.update(delta);
        sprite.renderTo(screen);

        sprite.incrementPositionBy( (int) delta / 10, 0);
        if (sprite.getX() > screen.width()) {
            randomize(screen.width(), screen.height());
        }
    }

    public void onStart(int width, int height) {
        randomize(width, height);
    }

    private void randomize(int width, int height) {
        int y = RandomNumberGenerator.getRandIntBetween(0, height - sprite.height());
        int x = -RandomNumberGenerator.getRandIntBetween(sprite.width(), sprite.width() + width);
        sprite.position(x, y);
    }
}
