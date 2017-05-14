package com.trewdev.blueworld.graphics.states;

import com.trewdev.blueworld.entities.creature.Player;
import com.trewdev.blueworld.game.Game;
import com.trewdev.blueworld.game.Handler;
import com.trewdev.blueworld.graphics.tiles.Tile;
import com.trewdev.blueworld.worlds.World;

import java.awt.*;

/**
 * Created by trew1 on 5/11/2017.
 */
public class GameState extends State {

    private World world;
    private Player player;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);
        player = new Player(handler, 100, 100);


    }

    @Override
    public void tick() {
        world.tick();
        player.tick();

    }

    @Override
    public void render(Graphics g) {

        world.render(g);
        player.render(g);


    }
}
