package com.aganci.shooter;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class RenderingThread implements Runnable {
    private static final int FPS = 30;
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
        thread = new Thread(this);

        running = true;
        thread.start();
    }

    @Override
    public void run() {
        while(running) {
            long startTime = System.nanoTime();
            render();
            long renderDuration = (System.nanoTime() - startTime) / 1000000;

            sleep( Math.max(2, (1000 / FPS) - renderDuration) );
        }
    }

    private void render() {
        screen.clear();
        game.renderTo(screen);
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
