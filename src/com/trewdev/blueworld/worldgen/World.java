package com.trewdev.blueworld.worldgen;

import com.trewdev.blueworld.entities.Entity;
import com.trewdev.blueworld.entities.EntityManager;
import com.trewdev.blueworld.entities.creature.Player;
import com.trewdev.blueworld.entities.statics.Tree;
import com.trewdev.blueworld.game.Game;
import com.trewdev.blueworld.game.Handler;
import com.trewdev.blueworld.game.Utils;
import com.trewdev.blueworld.graphics.tiles.Tile;
import com.trewdev.blueworld.items.ItemManager;

import java.awt.*;

/**
 * Created by trew1 on 5/11/2017.
 */
public class World {


    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    private ItemManager itemManager;

    private EntityManager entityManager;

    public World(Handler handler, String path) {
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        itemManager = new ItemManager(handler);
        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setyMove(spawnY);
        entityManager.addEntity(new Tree(handler, 100, 250));
        entityManager.addEntity(new Tree(handler, 300, 250));
        entityManager.addEntity(new Tree(handler, 400, 400));

    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private void loadWorld(String path) {

        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];


        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {


                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);

            }


        }


    }


    public void tick() {
        entityManager.tick();
        itemManager.tick();

    }

    public Tile getTile(int x, int y) {

        if (x < 0 || y < 0 || x >= width || y >= height)
            return Tile.grassTile;

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.grassTile;
        }
        return t;


    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void render(Graphics g) {


        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);

        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);


        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {

                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEWIDTH - handler.getGameCamera().getyOffset()));

            }
        }
        itemManager.render(g);

        entityManager.render(g);

    }

    public int getWidth() {

        return width;
    }

    public int getHeight() {
        return height;
    }
}
