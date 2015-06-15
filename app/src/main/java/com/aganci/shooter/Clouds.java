package com.aganci.shooter;

public class Clouds {
    public static Clouds create(Assets assets) {
        Cloud[] clouds = new Cloud[10];
        for (int i = 0; i < clouds.length; i++) {
            int number = RandomNumberGenerator.getRandIntBetween(1, 2);
            clouds[i] = new Cloud(assets.getBitmap("cloud-" + String.valueOf(number)));
        }
        return new Clouds(clouds);
    }

    private Cloud[] clouds;

    public Clouds(Cloud[] clouds) {

        this.clouds = clouds;
    }

    public void renderTo(Screen screen, long delta) {
        for(Cloud cloud : clouds) {
            cloud.renderTo(screen, delta);
        }
    }

    public void randomize(int width, int height) {
        for(Cloud cloud : clouds) {
            cloud.randomize(width, height);
        }
    }
}
