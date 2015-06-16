package com.aganci.shooter;

import android.graphics.Bitmap;

public class GameText {

    private Assets assets;

    public GameText(Assets assets) {
        this.assets = assets;
    }

    public void renderTo(String text, int x, int y, Screen screen) {
        for (int i = 0; i < text.length(); i++) {
            Bitmap bitmap = assets.getBitmap(String.valueOf(text.charAt(i)));
            screen.getCanvas().drawBitmap(
                    bitmap,
                    x, y, screen.getPaint());
            x += bitmap.getWidth() + 1;
        }
    }
}
