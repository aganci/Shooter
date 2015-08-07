package com.aganci.shooter;

public class Bird {
    public static Bird createBlueRightDirection(Assets assets) {
        return new Bird(new Sprite("blue-calm-bird-right-", 4, assets, 180), new LinearTrajectory(10));
    }

    public static Bird createBlueLeftDirection(Assets assets) {
        return new Bird(new Sprite("blue-calm-bird-left-", 4, assets, 180), new LinearTrajectory(-10));
    }

    public static Bird createGreen(Assets assets) {
        return new Bird(new Sprite("happy-green-yellow-bird-", 4, assets, 100), new LinearTrajectory(7));
    }

    public static Bird createYellow(Assets assets) {
        return new Bird(new Sprite("yellow-fat-bird-small-", 4, assets, 50), new LinearTrajectory(4));
    }

    public static Bird createGoose(Assets assets) {
        return new Bird(new Sprite("goose-", 4, assets, 250), new CircularTrajectory());
    }

    private final Sprite sprite;
    private Trajectory trajectory;

    protected Bird(Sprite sprite, Trajectory trajectory) {
        this.trajectory = trajectory;
        this.sprite = sprite;
    }

    public void renderTo(Screen screen, long delta) {
        sprite.update(delta);
        sprite.renderTo(screen);
        trajectory.updatePosition(sprite, delta);
    }

    public boolean hasHit(float x, float y) {
        return sprite.hasHit(x, y);
    }

    public int width() {
        return sprite.width();
    }

    public void position(int x, int y) {
        sprite.position(x, y);
    }
}
