package com.trewdev.blueworld.entities;

import com.trewdev.blueworld.game.Handler;

/**
 * Created by trew1 on 5/14/2017.
 */
public abstract class StaticEntity extends Entity {


    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
}
