package com.trewdev.blueworld.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by trew1 on 5/9/2017.
 */
public class ImageLoader {

    public static BufferedImage loadImage(String path){

        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }
}
