package com.aganci.shooter;

public class MenuScene implements GameScene {

    private Game game;
    private GameScene levelScene;

    public MenuScene(Game game, GameScene levelScene) {
        this.game = game;
        this.levelScene = levelScene;
    }

    @Override
    public void onStart(int width, int height) {

    }

    @Override
    public void renderTo(Screen screen, long delta) {

    }

    @Override
    public void onTouch(float x, float y) {
        game.changeScene(levelScene);
    }
}
