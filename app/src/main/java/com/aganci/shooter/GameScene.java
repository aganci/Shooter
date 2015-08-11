package com.aganci.shooter;

public interface GameScene {
    void onStart(int width, int height);
    void renderTo(Screen screen, long delta);
    void onTouch(float x, float y);
}
