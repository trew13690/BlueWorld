package com.trewdev.blueworld.graphics;

import com.trewdev.blueworld.graphics.ImageLoader;
import com.trewdev.blueworld.graphics.SpriteSheet;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;

/**
 * Created by trew1 on 5/10/2017.
 */
public class Assets {
    private static final int width = 55, height = 80;


    public  static BufferedImage[] player_standing, player_right;
    public  static  BufferedImage grassTile, tallGrassTile, rockTile;
    public static void init(){

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/dude.jpg"));

        player_standing = new BufferedImage[4];
        player_standing[0] = sheet.crop(0, height, width, height);
        player_standing[1] = sheet.crop(width, height, width, height);
        player_standing[2] = sheet.crop(width*2, height,width, height);
        player_standing[3] = sheet.crop(0,height,width,height);


        player_right = new BufferedImage[5];
        player_right[0] = sheet.crop(0, 0,width, height);
        player_right[1] = sheet.crop(width, 0, width,height);
        player_right[2] = sheet.crop(width *2, 0, width, height);
        player_right[3] = sheet.crop(width *3, 0, width, height);
        player_right[4] = sheet.crop(0,0, width, height);




        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/tileMap.jpg"));
        grassTile = sheet2.crop(0,0, 32, 32);
        tallGrassTile = sheet2.crop(96, 32, 32, 32);
        rockTile = sheet2.crop(32,192,32,32);






    }
}
