package com.trewdev.blueworld.entities.statics;

import com.trewdev.blueworld.entities.StaticEntity;
import com.trewdev.blueworld.game.Handler;
import com.trewdev.blueworld.graphics.Assets;
import com.trewdev.blueworld.items.Item;

import java.awt.*;

/**
 * Created by trew1 on 5/14/2017.
 */
public class Tree extends StaticEntity {


    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, 32*4, 32*4);

        bounds.x = 10;
        bounds.y = (int) (height /1.5f);
        bounds.width = width -20;
        bounds.height = (int) (height - height / 1.5f);

    }

    @Override
    public void tick() {



    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.greenTree, (int) (x- handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width,height,null);

    }
    @Override
    public void die(){
        handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int) x, (int) y));

    }
}
