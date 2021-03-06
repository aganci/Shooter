package com.aganci.shooter;

public class LevelScene implements GameScene {
    private Assets assets;
    private Level level;
    private final Score score;

    public LevelScene(Assets assets) {
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
        level = new LevelFactory(assets, score).createLevel3(width, height);
    }

    public void onTouch(float x, float y) {
        level.onTouch(x, y);
    }
}
