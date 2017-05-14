package com.trewdev.blueworld.graphics;

import com.trewdev.blueworld.graphics.ImageLoader;
import com.trewdev.blueworld.graphics.SpriteSheet;

import java.awt.image.BufferedImage;

/**
 * Created by trew1 on 5/10/2017.
 */
public class Assets {
    public  static BufferedImage playerWalk1, playerWalk2, playerWalk3, playerWalk4;
    private static final int width = 50, height = 70;

    public  static  BufferedImage grassTile, tallGrassTile, rockTile;
    public static void init(){

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/dude.jpg"));

        playerWalk1 = sheet.crop(0,0 , width, height);
        playerWalk2 = sheet.crop(width, 0, width,height);

        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/tileMap.jpg"));
        grassTile = sheet2.crop(0,0, 32, 32);
        tallGrassTile = sheet2.crop(96, 32, 32, 32);
        rockTile = sheet2.crop(32,192,32,32);






    }
}
