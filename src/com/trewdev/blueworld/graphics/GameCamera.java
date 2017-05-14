package com.trewdev.blueworld.graphics;

import com.trewdev.blueworld.entities.Entity;
import com.trewdev.blueworld.game.Game;
import com.trewdev.blueworld.game.Handler;
import com.trewdev.blueworld.graphics.tiles.Tile;

/**
 * Created by trew1 on 5/11/2017.
 */
public class GameCamera {

    private float xOffset, yOffset;
    private Handler handler;

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;


    }
    public void checkBlankSpace(){

        if(xOffset < 0){

            xOffset = 0;
        }else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){

            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        }
        if(yOffset < 0){

            yOffset = 0;
        }else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()){

            yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();

        }
    }

    public void move(float xAmt, float yAmt) {

        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();

    }

    public void centerOnEntity(Entity e) {

        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() /2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() /2;
        checkBlankSpace();
    }


}
