package com.trewdev.blueworld.entities;

import com.trewdev.blueworld.game.Game;

import java.awt.*;

/**
 * Created by trew1 on 5/11/2017.
 */
public abstract class Entity {

    protected float x, y;
    protected int width, height;
    protected Game game;

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

    public  Entity(Game game,float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.game = game;


    }


    public  abstract void tick();
    public abstract void render(Graphics g);



}
