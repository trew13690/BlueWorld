package com.trewdev.blueworld.entities;

import com.trewdev.blueworld.game.Game;
import com.trewdev.blueworld.game.Handler;

import java.awt.*;

/**
 * Created by trew1 on 5/11/2017.
 */
public abstract class Entity {

    protected float x, y;
    protected int width, height;
    protected Handler handler;
    protected Rectangle bounds;
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {

        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public  Entity(Handler handler, float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;

        bounds = new Rectangle(0,0,width, height);

    }


    public  abstract void tick();
    public abstract void render(Graphics g);



}
