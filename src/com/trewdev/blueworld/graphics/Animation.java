package com.trewdev.blueworld.graphics;

import java.awt.image.BufferedImage;

/**
 * Created by trew1 on 5/14/2017.
 */
public class Animation {

    private  int speed, index;
    private BufferedImage[] frames;
    private long lastTime;
    private long timer;

    public  Animation(int speed, BufferedImage[] frames){

        this.speed = speed;
        this.frames = frames;
        index = 0;
        lastTime = System.currentTimeMillis();
        timer = 0;
    }

    public  void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){

            index++;
            timer = 0;
            if(index >= frames.length){

                index = 0;
            }
        }
    }
    public  BufferedImage getCurrentFrame(){
        return frames[index];
    }


}
