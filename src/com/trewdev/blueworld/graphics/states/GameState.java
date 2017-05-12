package com.trewdev.blueworld.graphics.states;

import com.trewdev.blueworld.entities.creature.Player;
import com.trewdev.blueworld.game.Game;
import com.trewdev.blueworld.graphics.tiles.Tile;
import com.trewdev.blueworld.worlds.World;

import java.awt.*;

/**
 * Created by trew1 on 5/11/2017.
 */
public class GameState extends State {

    private World world;
    private Player player;
    public GameState(Game game){
            super(game);
        player = new Player(game,100, 100);
        world = new World(game,"res/worlds/world1.txt");



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
