package com.aganci.shooter;

public class Game {
    private Assets assets;
    private Level level;
    private final GameText text;

    public Game(Assets assets) {
        this.assets = assets;
        text = new GameText(assets);
    }

    public void renderTo(Screen screen, long delta) {
        level.renderTo(screen, delta);
        text.renderTo("012345012345", 10, 10, screen);
    }

    public void onStart(int width, int height) {
        level = Level.create(width, height, assets);
    }

    private Bird randomizeBird(Assets assets) {
        int birdType = RandomNumberGenerator.getRandIntBetween(0, 3);
        if (birdType == 0) return new Bird(assets, "yellow-fat-bird-small-", 4, 50);
        if (birdType == 1) return Bird.createGreen(assets);
        if (birdType == 2) return Bird.createBlueRightDirection(assets);
        if (birdType == 3) return new Bird(assets, "goose-", 14, 250);
        return null;
    }

    public void onTouch(float x, float y) {
        level.onTouch(x, y);
    }
}
