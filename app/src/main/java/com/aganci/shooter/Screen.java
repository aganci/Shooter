package com.aganci.shooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Screen {
    private Bitmap bitmap;
    private Paint paint;
    Rect rect = new Rect();
    private Canvas bitmapCanvas;
    private int backgroundColor;

    public Screen(int backgroundColor) {

        this.backgroundColor = backgroundColor;
    }

    public void onSizeChanged(int width, int height) {
        rect.set(0, 0, width, height);
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        paint = new Paint();
        bitmapCanvas = new Canvas(bitmap);
    }

    public void renderTo(Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }

    public void clear() {
        paint.setColor(backgroundColor);
        bitmapCanvas.drawRect(rect, paint);
    }
}
