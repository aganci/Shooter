package com.aganci.shooter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class GameView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {
    final RenderingThread thread;
    private final Game game;

    public GameView(Context context, Assets assets) {
        super(context);
        setOnTouchListener(this);
        getHolder().addCallback(this);
        game = new Game(assets);
        thread = new RenderingThread(new Screen(Color.rgb(126, 202, 247)), getHolder(), game);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("GameView", "surfaceCreated");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d("GameView", "surfaceChanged Width: " + width + "  Height: " + height);
        thread.start(width, height);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("GameView", "surfaceDestroyed");
        thread.stop();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_UP) {
            game.onTouch(event.getX(), event.getY());
        }
        return false;
    }
}
