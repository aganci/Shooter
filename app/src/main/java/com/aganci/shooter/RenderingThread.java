package com.aganci.shooter;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class RenderingThread implements Runnable {
    private static final int FPS = 60;
    Thread thread;
    private Screen screen;
    private SurfaceHolder holder;
    private Game game;
    private boolean running;

    public RenderingThread(Screen screen, SurfaceHolder holder, Game game) {

        this.screen = screen;
        this.holder = holder;
        this.game = game;
    }

    public void start(int width, int height) {
        screen.onSizeChanged(width, height);
        game.onStart(width, height);
        thread = new Thread(this);

        running = true;
        thread.start();
    }

    @Override
    public void run() {
        long delta = 0;

        while(running) {
            long startTime = System.nanoTime();

            render(delta);

            long renderDuration = (System.nanoTime() - startTime) / 1000000;
            long sleepDuration = Math.max(2, (1000 / FPS) - renderDuration);
            delta = renderDuration + sleepDuration;

            sleep(sleepDuration);
        }
    }

    private void render(long delta) {
        screen.clear();
        game.renderTo(screen, delta);
        Canvas canvas = holder.lockCanvas();
        if (canvas == null) {
            return;
        }
        screen.renderTo(canvas);
        holder.unlockCanvasAndPost(canvas);
    }

    private void sleep(long duration) {
        try {
            thread.sleep(duration);
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
