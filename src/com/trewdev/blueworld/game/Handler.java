package com.trewdev.blueworld.game;

import com.trewdev.blueworld.graphics.GameCamera;
import com.trewdev.blueworld.input.KeyManager;
import com.trewdev.blueworld.input.MouseManger;
import com.trewdev.blueworld.worldgen.World;

/**
 * Created by trew1 on 5/14/2017.
 */
public class Handler {

    private Game game;
    private World world;

    public Game getGame() {
        return game;
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public MouseManger getMouseManger() {
        return game.getMouseManger();
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Handler(Game game) {


        this.game = game;

    }
}
