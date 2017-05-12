package com.trewdev.blueworld.worlds;

import com.trewdev.blueworld.game.Game;
import com.trewdev.blueworld.game.Utils;
import com.trewdev.blueworld.graphics.tiles.Tile;

import java.awt.*;

/**
 * Created by trew1 on 5/11/2017.
 */
public class World {


    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    private Game game;

    public World(Game game, String path) {
        this.game = game;
        loadWorld(path);

    }


    private void loadWorld(String path) {

        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[3]);
        spawnY = Utils.parseInt(tokens[4]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {


                tiles[x][y] = Utils.parseInt(tokens[x + y * width] + 4);

            }


        }


    }


    public void tick() {


    }

    public Tile getTile(int x, int y) {

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null)
            return Tile.grassTile;
        return t;


    }

    public void render(Graphics g) {


        int xStart =(int) Math.max(0, game.getGameCamera().getxOffset() / Tile.TILEWIDTH ) ;
        int xEnd = (int) Math.min(width,(game.getGameCamera().getxOffset() + game.getWidth()) / Tile.TILEWIDTH + 1);

        int yStart = (int) Math.max(0, game.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (game.getGameCamera().getyOffset() + game.getHeight() / Tile.TILEHEIGHT +1));




        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {

                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - game.getGameCamera().getxOffset()), (int) (y * Tile.TILEWIDTH - game.getGameCamera().getyOffset()));

            }
        }
    }
}
