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
    protected int Health;
    public static final int DEFAULT_HEALTH = 10;

    protected boolean active = true;

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

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
        this.Health = 3;
        bounds = new Rectangle(0,0,width, height);

    }
    public  Rectangle getCollisionBounds(float xOffset, float yOffset){

        return new Rectangle((int) (x + bounds.x + xOffset), (int)(y+ bounds.y + yOffset), bounds.width, bounds.height);

    }

   public boolean checkEntityCollisions(float xOffset, float yOffset) {
       for (Entity e : handler.getWorld().getEntityManager().getEntities()){
           if(e.equals(this))
               continue;
           if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
               return true;
   }
        return false;
   }

   public void hurt(int amt){
        Health -= amt;
        if(Health <= 0)
            active = false;
        die();
   }
   public abstract void die();



    public  abstract void tick();
    public abstract void render(Graphics g);



}
