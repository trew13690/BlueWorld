package com.trewdev.blueworld.graphics;

import com.trewdev.blueworld.graphics.ImageLoader;
import com.trewdev.blueworld.graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.nio.Buffer;

/**
 * Created by trew1 on 5/10/2017.
 */
public class Assets {
    private static final int width = 32, height = 32;

    public static BufferedImage greenTree;


    public static BufferedImage[] red_character_standing;
    public static BufferedImage red_character_static;
    public static BufferedImage[] red_character_right,
            red_character_down,
            red_character_left,
            red_character_up;

    public static BufferedImage[] MenuButtons;
    public static Font font28;
    public static BufferedImage woodPile;
    public static BufferedImage woodStump;

    public static BufferedImage grassTile, tallGrassTile, rockTile;

    public static BufferedImage inventory;


    public static void init() {

        font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 28);


        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/tileMap.jpg"));
        grassTile = sheet2.crop(0, 0, 32, 32);
        tallGrassTile = sheet2.crop(96, 32, 32, 32);
        rockTile = sheet2.crop(32, 192, 32, 32);


        //Red_character
        SpriteSheet sheetRed = new SpriteSheet(ImageLoader.loadImage("/textures/red_character.png"));

        red_character_static = sheetRed.crop(32, 0, 32, 32);

        red_character_standing = new BufferedImage[2];
        red_character_standing[0] = sheetRed.crop(32, 0, 32, 32);
        red_character_standing[1] = sheetRed.crop(32, 96, 32, 32);

        red_character_right = new BufferedImage[4];
        red_character_right[0] = sheetRed.crop(32, 64, 32, 32);
        red_character_right[1] = sheetRed.crop(64, 64, 32, 32);
        red_character_right[2] = sheetRed.crop(0, 64, 32, 32);
        red_character_right[3] = sheetRed.crop(32, 64, 32, 32);


        red_character_left = new BufferedImage[4];
        red_character_left[0] = sheetRed.crop(32, 32, 32, 32);
        red_character_left[1] = sheetRed.crop(64, 32, 32, 32);
        red_character_left[2] = sheetRed.crop(0, 32, 32, 32);
        red_character_left[3] = sheetRed.crop(32, 32, 32, 32);


        red_character_down = new BufferedImage[4];
        red_character_down[0] = sheetRed.crop(32, 0, 32, 32);
        red_character_down[1] = sheetRed.crop(64, 0, 32, 32);
        red_character_down[2] = sheetRed.crop(0, 0, 32, 32);
        red_character_down[3] = sheetRed.crop(32, 0, 32, 32);

        red_character_up = new BufferedImage[4];
        red_character_up[0] = sheetRed.crop(32, 96, 32, 32);
        red_character_up[1] = sheetRed.crop(64, 96, 32, 32);
        red_character_up[2] = sheetRed.crop(0, 96, 32, 32);
        red_character_up[3] = sheetRed.crop(32, 96, 32, 32);
        //Tree Assest

        greenTree = sheet2.crop(0, 512, 128, 160);

        woodPile = sheet2.crop(160, 32, 64, 32);
        woodStump = sheet2.crop(160, 0, 64, 32);

        //MenuButtons
        SpriteSheet menuSheet = new SpriteSheet(ImageLoader.loadImage("/textures/sample_UI_Buttons.jpg"));

        MenuButtons = new BufferedImage[3];
        MenuButtons[0] = menuSheet.crop(151, 85, 241, 64);
        MenuButtons[1] = menuSheet.crop(151, 185, 241, 64);
        MenuButtons[2] = menuSheet.crop(151, 285, 241, 64);


        //Inventory

        SpriteSheet inventorySheet = new SpriteSheet(ImageLoader.loadImage("/textures/inventory_Sample.jpg"));
        inventory = inventorySheet.crop(110, 124, 332, 455);
    }
}
