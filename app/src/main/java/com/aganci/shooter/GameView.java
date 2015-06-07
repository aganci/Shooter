package com.aganci.shooter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    final RenderingThread thread;

    public GameView(Context context, Assets assets) {
        super(context);
        getHolder().addCallback(this);
        thread = new RenderingThread(new Screen(Color.GREEN), getHolder(), new Game(assets));
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

}
