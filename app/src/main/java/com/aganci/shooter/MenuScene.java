package com.aganci.shooter;

public class MenuScene implements GameScene {

    private Game game;
    private GameScene levelScene;
    private final GameText text;

    public MenuScene(Game game, GameScene levelScene, Assets assets) {
        this.game = game;
        this.levelScene = levelScene;
        text = new GameText(assets);
    }

    @Override
    public void onStart(int width, int height) {

    }

    @Override
    public void renderTo(Screen screen, long delta) {
        text.renderTo("C", 100, 100, screen);
    }

    @Override
    public void onTouch(float x, float y) {
        game.changeScene(levelScene);
    }
}
