package com.trewdev.blueworld.items;

import com.trewdev.blueworld.game.Handler;
import com.trewdev.blueworld.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 * Created by trew1 on 5/15/2017.
 */
public class Item {

    //Handler

    public static Item[] items = new Item[256];
    public static Item woodItem = new Item(Assets.woodPile, "Wood", 0);


    //Class

    public static final int ITEMWIDTH = 64, ITEMHEIGHT = 32;
    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;

    protected Rectangle bounds;

    protected int x, y, count;
    protected boolean pickedUp = false;


    public Item(BufferedImage texture, String name, int id) {

        this.texture = texture;
        this.name = name;
        this.id = id;
        count = 1;
        bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
        items[id] = this;

    }


    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

    public void tick() {

        if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
            pickedUp = true;
            handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);

        }

    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void render(Graphics g) {
        if (handler == null)
            return;

        render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
    }

    public void render(Graphics g, int x, int y) {

        g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);


    }

    public void setPostion(int x, int y) {

        this.x = x;
        this.y = y;

        bounds.x = x;
        bounds.y = y;
    }

    public Item createNew(int x, int y) {

        Item i = new Item(texture, name, id);
        i.setPostion(x, y);
        return i;


    }

    //testing only
    public Item createNew(int count){
        Item i = new Item(texture, name, id);
        i.setPickedUp(true);
        i.setCount(count);
        return i;
    }
}
