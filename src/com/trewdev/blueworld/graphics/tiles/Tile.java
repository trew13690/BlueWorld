package com.trewdev.blueworld.graphics.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by trew1 on 5/11/2017.
 */
public class Tile {

    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile rockTile = new RockTile(1);
    



    public static final int TILEWIDTH = 32, TILEHEIGHT = 32;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {

        this.texture = texture;
        this.id = id;

        tiles[id] = this;

    }


    public  int getId(){return  id;}

    public void tick(){

    }

    public  void render(Graphics g, int x , int y){

        g.drawImage(texture, x,y,TILEWIDTH, TILEHEIGHT,null);
    }


    public  boolean isSolid(){
        return false;

    }
}
