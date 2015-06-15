package com.aganci.shooter;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Assets {
    private AssetManager assets;
    private HashMap<String, Bitmap> images = new HashMap<String, Bitmap>();

    public Assets(AssetManager assets) {
        this.assets = assets;
    }

    public void load() {
        images.put("yellow-fat-bird-small-1", loadBitmap("yellow-fat-bird-small-1.png"));
        images.put("yellow-fat-bird-small-2", loadBitmap("yellow-fat-bird-small-2.png"));
        images.put("yellow-fat-bird-small-3", loadBitmap("yellow-fat-bird-small-3.png"));
        images.put("yellow-fat-bird-small-4", loadBitmap("yellow-fat-bird-small-4.png"));

        images.put("happy-green-yellow-bird-1", loadBitmap("happy-green-yellow-bird-1.png"));
        images.put("happy-green-yellow-bird-2", loadBitmap("happy-green-yellow-bird-2.png"));
        images.put("happy-green-yellow-bird-3", loadBitmap("happy-green-yellow-bird-3.png"));
        images.put("happy-green-yellow-bird-4", loadBitmap("happy-green-yellow-bird-4.png"));

        images.put("blue-calm-bird-right-1", loadBitmap("blue-calm-bird-right-1.png"));
        images.put("blue-calm-bird-right-2", loadBitmap("blue-calm-bird-right-2.png"));
        images.put("blue-calm-bird-right-3", loadBitmap("blue-calm-bird-right-3.png"));
        images.put("blue-calm-bird-right-4", loadBitmap("blue-calm-bird-right-4.png"));

        images.put("blue-calm-bird-left-1", loadBitmap("blue-calm-bird-left-1.png"));
        images.put("blue-calm-bird-left-2", loadBitmap("blue-calm-bird-left-2.png"));
        images.put("blue-calm-bird-left-3", loadBitmap("blue-calm-bird-left-3.png"));
        images.put("blue-calm-bird-left-4", loadBitmap("blue-calm-bird-left-4.png"));

        images.put("goose-1", loadBitmap("goose-1.png"));
        images.put("goose-2", loadBitmap("goose-2.png"));
        images.put("goose-3", loadBitmap("goose-3.png"));
        images.put("goose-4", loadBitmap("goose-4.png"));

        images.put("cloud-1", loadBitmap("cloud-1.png"));
        images.put("cloud-2", loadBitmap("cloud-2.png"));
    }

    private Bitmap loadBitmap(String filename) {
        InputStream inputStream = null;
        try {
            inputStream = assets.open(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public Bitmap getBitmap(String name) {
        return images.get(name);
    }
}
