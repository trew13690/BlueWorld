package com.trewdev.blueworld.UI;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.trewdev.blueworld.game.Handler;
import com.trewdev.blueworld.graphics.Assets;
import com.trewdev.blueworld.items.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by trew1 on 5/15/2017.
 */
public class Inventory {

    private Handler handler;
    private boolean active = false;

    private int invX = 65, invY = 48,
            invWidth = 512, invHeight = 384,
            invListCenterX = invX + 172,
            InvListCenter = invY + invHeight / 2 + 5;

    private ArrayList<Item> inventoryItems;

    public Inventory(Handler handler) {


        this.handler = handler;

        this.inventoryItems = new ArrayList<Item>();

        addItem(Item.woodItem.createNew(5));
    }


    public void tick() {
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            active = !active;
        if (!active)
            return;

        System.out.println("INVENTORY");
        for (Item i : inventoryItems) {

            System.out.println(i.getName() + " " + i.getCount());

        }


    }

    //Inventory Methods

    public void addItem(Item item) {
        for (Item i : inventoryItems) {
            if (i.getId() == item.getId()) {
                i.setCount(i.getCount() + item.getCount());
                return;
            }

        }
        inventoryItems.add(item);
    }


    public void render(Graphics g) {
        if (!active)
            return;
        g.drawImage(Assets.inventory, invX, invY, invWidth, invHeight, null );


        Text.drawString(g,"Wood", invListCenterX, invListCenterX, true, Color.white,Assets.font28);

    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
