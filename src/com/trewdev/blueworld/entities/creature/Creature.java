package com.trewdev.blueworld.entities.creature;

import com.trewdev.blueworld.entities.Entity;
import com.trewdev.blueworld.game.Game;
import com.trewdev.blueworld.game.Handler;
import com.trewdev.blueworld.graphics.tiles.Tile;

/**
 * Created by trew1 on 5/11/2017.
 */
public abstract class Creature extends Entity {

    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 75;
    public static final int DEFAULT_CREATURE_HEIGHT = 100;



    protected float speed;
    protected float xMove, yMove;



    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);

        speed = DEFAULT_SPEED;

        xMove = 0;
        yMove = 0;


    }

    public void move() {

        if(!checkEntityCollisions(xMove,0f))
             moveX();
        if(!checkEntityCollisions(0f,yMove))
            moveY();


    }

    public void moveX() {
        if (xMove > 0) {  //Moving right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {

                x += xMove;
            }else{

                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1 ;
            }
        } else if (xMove < 0) { // Moving left
            int tx = (int) (x + xMove + bounds.x ) / Tile.TILEHEIGHT;

            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {

                x += xMove;

            }else {

                x = tx * Tile.TILEWIDTH + Tile.TILEHEIGHT - bounds.x;
            }
        }
    }

    public void moveY() {
        if (yMove < 0) {
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile(((int) (x + bounds.x) + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            }else{

                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }
        } else if (yMove > 0) {

            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile(((int) (x + bounds.x) + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;

            }else {

                y = ty * Tile.TILEHEIGHT - bounds.y -bounds.height -1;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y) {

        return handler.getWorld().getTile(x, y).isSolid();

    }
    public void die(){}

}
