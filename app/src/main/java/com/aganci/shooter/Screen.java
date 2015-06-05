package com.aganci.shooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Screen {

    private int width;
    private int height;
    private Bitmap bitmap;
    private Paint paint;

    public void onSizeChanged(int width, int height) {
        this.width = width;
        this.height = height;
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        paint = new Paint();
    }

    public void render(Canvas canvas) {
        clear(canvas);
    }

    private void clear(Canvas canvas) {
        paint.setColor(Color.CYAN);
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
