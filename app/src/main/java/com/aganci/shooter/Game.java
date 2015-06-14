package com.aganci.shooter;

import java.util.ArrayList;

public class Game {
    ArrayList<Bird> birds;
    Clouds clouds;

    private int width;
    private int height;
    private Assets assets;

    public Game(Assets assets) {
        this.assets = assets;
    }

    public void renderTo(Screen screen, long delta) {
        for(Bird bird : birds) {
            bird.renderTo(screen, delta);
        }
        clouds.renderTo(screen, delta);
    }

    public void onStart(int width, int height) {
        this.width = width;
        this.height = height;

        birds = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Bird bird = randomizeBird(assets);
            bird.randomize(width, height);
            birds.add(bird);
        }
        clouds = Clouds.create(assets);
        clouds.randomize(width, height);
    }

    private Bird randomizeBird(Assets assets) {
        int birdType = RandomNumberGenerator.getRandIntBetween(0, 3);
        if (birdType == 0) return new Bird(assets, "yellow-fat-bird-small-", 4, 50);
        if (birdType == 1) return new Bird(assets, "happy-green-yellow-bird-", 7, 100);
        if (birdType == 2) return new Bird(assets, "blue-calm-bird-", 10, 180);
        if (birdType == 3) return new Bird(assets, "goose-", 14, 250);
        return null;
    }

    public void onTouch(float x, float y) {
        for (int i = birds.size() - 1; i >= 0; i--) {
            Bird bird = birds.get(i);
            if (bird.hasHit(x, y)) {
                bird.randomize(width, height);
                break;
            }
        }
    }
}
