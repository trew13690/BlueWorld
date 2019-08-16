package com.trewdev.blueworld.graphics;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 * Created by trew1 on 5/9/2017.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public  SpriteSheet(BufferedImage sheet){

        this.sheet = sheet;


    }
    public BufferedImage crop(int x, int y , int width, int height){


            return  sheet.getSubimage(x, y, width, height);




    }

}
