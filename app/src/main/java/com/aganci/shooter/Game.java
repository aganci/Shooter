package com.aganci.shooter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Game {
    private Paint paint = new Paint();
    private Rect textBounds = new Rect();
    private long delta;


    public void renderTo(Screen screen) {
        Canvas screenCanvas = screen.getCanvas();

        String text = String.valueOf(delta);
        paint.setTextSize(100);
        paint.setColor(Color.WHITE);
        paint.getTextBounds(text, 0, text.length(), textBounds);

        screenCanvas.drawText(text, (screen.width() / 2) - (textBounds.width() / 2), (screen.height() / 2) - (textBounds.height() / 2), paint);
    }

    public void update(long delta) {
        this.delta = delta;
    }
}
