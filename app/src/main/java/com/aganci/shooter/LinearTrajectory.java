package com.aganci.shooter;

public class LinearTrajectory implements Trajectory {

    private int velocity;

    public LinearTrajectory(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public void updatePosition(Sprite sprite, long delta) {
        sprite.incrementPositionBy((int) delta / velocity, 0);
    }
}
