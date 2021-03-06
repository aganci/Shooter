package com.aganci.shooter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    private final List<Bird> birds;
    private Clouds clouds;
    private Score score;

    public Level(ArrayList<Bird> birds, Clouds clouds, Score score) {
        this.score = score;
        this.birds = Collections.synchronizedList(birds);
        this.clouds = clouds;
    }

    public void renderTo(Screen screen, long delta) {
        synchronized (birds) {
            for (Bird bird : birds) {
                bird.renderTo(screen, delta);
            }
        }
        clouds.renderTo(screen, delta);
        score.renderTo(screen);
    }

    public void onTouch(float x, float y) {
        synchronized (birds) {
            for (int i = birds.size() - 1; i >= 0; i--) {
                Bird bird = birds.get(i);
                if (bird.hasHit(x, y)) {
                    birds.remove(bird);
                    score.increment(1);
                    break;
                }
            }
        }
    }

    public boolean finished() {
        synchronized (birds) {
            return birds.isEmpty();
        }
    }
}
