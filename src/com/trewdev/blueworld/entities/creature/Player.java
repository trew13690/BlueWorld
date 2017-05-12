package com.trewdev.blueworld.entities.creature;

import com.trewdev.blueworld.game.Game;
import com.trewdev.blueworld.graphics.Assets;

import java.awt.*;

/**
 * Created by trew1 on 5/11/2017.
 */
public class Player extends Creature {



    public Player(Game game, float x, float y) {
        super(game,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);


    }

    @Override
    public void tick() {
        getInput();
        move();
        game.getGameCamera().centerOnEntity(this);
    }
    private  void getInput(){


        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up)
            yMove = -speed;
        if(game.getKeyManager().down)
            yMove = speed;
        if(game.getKeyManager().left)
            xMove = -speed;
        if(game.getKeyManager().right)
            xMove = speed;


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerWalk1, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()),width, height, null);

    }
}
