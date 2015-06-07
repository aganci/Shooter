package com.aganci.shooter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;

public class RenderingThread implements Runnable {
    Thread thread;
    private Screen screen;
    private SurfaceHolder holder;
    private boolean running;

    public RenderingThread(Screen screen, SurfaceHolder holder) {

        this.screen = screen;
        this.holder = holder;
    }

    public void start(int width, int height) {
        screen.onSizeChanged(width, height);
        thread = new Thread(this);

        running = true;
        thread.start();
    }

    @Override
    public void run() {
        int frame = 0;
        Paint paint = new Paint();
        Rect textBounds = new Rect();

        while(running) {
            screen.clear();

            Canvas screenCanvas = screen.getCanvas();

            String text = String.valueOf(frame);
            paint.setTextSize(100);
            paint.setColor(Color.WHITE);
            paint.getTextBounds(text, 0, text.length(), textBounds);

            screenCanvas.drawText(text, (screen.width() / 2) - (textBounds.width() / 2), (screen.height() / 2) - (textBounds.height() / 2), paint);

            renderScreen();

            frame++;
        }
    }

    private void renderScreen() {
        Canvas canvas = holder.lockCanvas();
        if (canvas == null) {
            return;
        }
        screen.renderTo(canvas);
        holder.unlockCanvasAndPost(canvas);

        try {
            thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            Log.d("RenderingThread", e.toString());
        }
    }
}
