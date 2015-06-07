package com.aganci.shooter;

public class Game {
    Bird[] birds;

    public Game(Assets assets) {
        birds = new Bird[50];
        for (int i = 0; i < birds.length; i++) {
            birds[i] = randomizeBird(assets);
        }
    }

    private Bird randomizeBird(Assets assets) {
        int birdType = RandomNumberGenerator.getRandIntBetween(0, 3);
        if (birdType == 0) return new Bird(assets, "yellow-fat-bird-small-", 4, 50);
        if (birdType == 1) return new Bird(assets, "happy-green-yellow-bird-", 7, 100);
        if (birdType == 2) return new Bird(assets, "blue-calm-bird-", 12, 180);
        if (birdType == 3) return new Bird(assets, "goose-", 18, 250);
        return null;
    }

    public void renderTo(Screen screen, long delta) {
        for(Bird bird : birds) {
            bird.renderTo(screen, delta);
        }
    }

    public void onStart(int width, int height) {
        for(Bird bird : birds) {
            bird.onStart(width, height);
        }
    }
}
