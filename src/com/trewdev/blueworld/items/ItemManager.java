package com.trewdev.blueworld.items;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.trewdev.blueworld.game.Handler;
import sun.management.snmp.jvmmib.JvmThreadInstanceTableMeta;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by trew1 on 5/15/2017.
 */
public class ItemManager {

    private Handler handler;

    private ArrayList<Item> items;


    public ItemManager(Handler handler){


        this.handler = handler;
        items = new ArrayList<Item>();
    }

    public void tick(){

        Iterator<Item> it = items.iterator();

        while(it.hasNext()){

            Item i = it.next();
            i.tick();
            if(i.isPickedUp())
                it.remove();

        }


    }

    public void render(Graphics g){
        for(Item i : items)
            i.render(g);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);

    }




}
