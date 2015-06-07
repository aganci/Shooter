package com.aganci.shooter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Game {
    private int frame = 0;
    private Paint paint = new Paint();
    private Rect textBounds = new Rect();


    public void renderTo(Screen screen) {
        Canvas screenCanvas = screen.getCanvas();

        String text = String.valueOf(frame);
        paint.setTextSize(100);
        paint.setColor(Color.WHITE);
        paint.getTextBounds(text, 0, text.length(), textBounds);

        screenCanvas.drawText(text, (screen.width() / 2) - (textBounds.width() / 2), (screen.height() / 2) - (textBounds.height() / 2), paint);

        frame += 1;
    }
}
