package com.trewdev.blueworld.graphics.states;

import com.trewdev.blueworld.entities.creature.Player;

import com.trewdev.blueworld.entities.statics.Tree;
import com.trewdev.blueworld.game.Handler;

import com.trewdev.blueworld.worlds.World;

import java.awt.*;

/**
 * Created by trew1 on 5/11/2017.
 */
public class GameState extends State {

    private World world;



    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);



    }

    @Override
    public void tick() {
        world.tick();




    }

    @Override
    public void render(Graphics g) {

        world.render(g);


    }
}
