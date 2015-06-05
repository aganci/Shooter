package com.aganci.shooter;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    Screen screen = new Screen();


    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("GameView", "surfaceCreated Width: " + getWidth() + "  Height: " + getHeight());
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d("GameView", "surfaceChanged Width: " + width + "  Height: " + height);
        screen.onSizeChanged(width, height);
        Canvas canvas = getHolder().lockCanvas();
        screen.render(canvas);
        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("GameView", "surfaceDestroyed");
    }

}
