package com.aganci.shooter;

import java.util.ArrayList;

public class LevelFactory {
    Assets assets;
    private Score score;

    public LevelFactory(Assets assets, Score score) {
        this.assets = assets;
        this.score = score;
    }

    public Level createLevel1(int width, int height) {
        ArrayList<Bird> birds = new ArrayList<>();
        Bird blueRightDirection = Bird.createBlueRightDirection(assets);
        blueRightDirection.position(-blueRightDirection.width(), height / 2);
        birds.add(blueRightDirection);

        Bird blueLeftDirection = Bird.createBlueLeftDirection(assets);
        blueLeftDirection.position(width, height / 2);
        birds.add(blueLeftDirection);

        return new Level(birds, new Clouds(new Cloud[0]), score);
    }

    public Level createLevel2(int width, int height) {
        ArrayList<Bird> birds = new ArrayList<>();

        int endBlueRowX = addBlueRightDirectionRowTo(birds, 0, height / 4);
        addBlueRightDirectionRowTo(birds, 0, height * 3 / 4);

        addBlueLeftDirectionTo(birds, width, height / 4);
        addBlueLeftDirectionTo(birds, width, height * 3 / 4);

        int endGreenRow = addGreenRowTo(birds, endBlueRowX, height / 2);

        addGreenRowTo(birds, endGreenRow * 2, height / 2);

        return new Level(birds, new Clouds(new Cloud[0]), score);
    }

    private int addGreenRowTo(ArrayList<Bird> birds, int x, int y) {
        for (int i = 0; i < 20; i++) {
            Bird green = Bird.createGreen(assets);
            x -= green.width();
            green.position(x, y);
            birds.add(green);
        }
        return x;
    }

    private void addBlueLeftDirectionTo(ArrayList<Bird> birds, int x, int y) {
        for (int i = 0; i < 10; i++) {
            Bird blue = Bird.createBlueLeftDirection(assets);
            x += blue.width();
            blue.position(x, y);
            birds.add(blue);
        }
    }

    private int addBlueRightDirectionRowTo(ArrayList<Bird> birds, int x, int y) {
        for (int i = 0; i < 10; i++) {
            Bird blue = Bird.createBlueRightDirection(assets);
            x -= blue.width();
            blue.position(x, y);
            birds.add(blue);
        }
        return x;
    }

}
