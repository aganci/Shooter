package com.aganci.shooter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    private final List<Bird> birds;
    private Clouds clouds;
    private GameText gameText;

    public static Level create(int width, int height, Assets assets) {
        ArrayList<Bird> birds = new ArrayList<>();

        int x = 0;
        for (int i = 0; i < 10; i++) {
            Bird blue = Bird.createBlueRightDirection(assets);
            x -= blue.width();
            blue.position(x, height / 4);
            birds.add(blue);
        }

        x = width;
        for (int i = 0; i < 10; i++) {
            Bird blue = Bird.createBlueLeftDirection(assets);
            x += blue.width();
            blue.position(x, height / 4);
            birds.add(blue);
        }

        x = 0;
        for (int i = 0; i < 10; i++) {
            Bird blue = Bird.createBlueRightDirection(assets);
            x -= blue.width();
            blue.position(x, height * 3 / 4);
            birds.add(blue);
        }

        x = width;
        for (int i = 0; i < 10; i++) {
            Bird blue = Bird.createBlueLeftDirection(assets);
            x += blue.width();
            blue.position(x, height * 3 / 4);
            birds.add(blue);
        }


        for (int i = 0; i < 20; i++) {
            Bird green = Bird.createGreen(assets);
            x -= green.width();
            green.position(x, height / 2);
            birds.add(green);
        }


        return new Level(birds, new Clouds(new Cloud[0]));
    }

    public Level(ArrayList<Bird> birds, Clouds clouds) {
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
    }

    public void onTouch(float x, float y) {
        synchronized (birds) {
            for (int i = birds.size() - 1; i >= 0; i--) {
                Bird bird = birds.get(i);
                if (bird.hasHit(x, y)) {
                    birds.remove(bird);
                    break;
                }
            }
        }
    }
}
