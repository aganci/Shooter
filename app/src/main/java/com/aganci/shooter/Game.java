package com.aganci.shooter;

public class Game {
    private GameScene currentScene;
    private int width;
    private int height;

    public void onSizeChanged(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void renderTo(Screen screen, long delta) {
        currentScene.renderTo(screen, delta);
    }

    public void onTouch(float x, float y) {
        currentScene.onTouch(x, y);
    }

    public void changeScene(GameScene scene) {
        currentScene = scene;
        onSizeChanged(width, height);
        currentScene.onStart(width, height);
    }
}
