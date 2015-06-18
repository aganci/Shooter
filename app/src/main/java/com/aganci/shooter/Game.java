package com.aganci.shooter;

public class Game {
    private Assets assets;
    private Level level;
    private final Score score;

    public Game(Assets assets) {
        this.assets = assets;
        score = new Score(new GameText(assets));
    }

    public void renderTo(Screen screen, long delta) {
        level.renderTo(screen, delta);
        score.renderTo(screen);

        if (level.finished()) {
            level = new LevelFactory(assets, score).createLevel2(screen.width(), screen.height());
        }
    }

    public void onStart(int width, int height) {
        level = new LevelFactory(assets, score).createLevel1(width, height);
    }

    public void onTouch(float x, float y) {
        level.onTouch(x, y);
    }
}
