package com.trewdev.blueworld.entities.creature;

import com.trewdev.blueworld.game.Game;
import com.trewdev.blueworld.game.Handler;
import com.trewdev.blueworld.graphics.Animation;
import com.trewdev.blueworld.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by trew1 on 5/11/2017.
 */
public class Player extends Creature {

    //Animations

    private Animation animStanding;
    private Animation animRight;
    public Player(Handler handler, float x, float y) {
        super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 25;
        bounds.y = 65;
        bounds.width = 32;
        bounds.height = 32;


        //Animations
        animStanding = new Animation(300, Assets.player_standing);
        animRight = new Animation(150, Assets.player_right);
    }

    @Override
    public void tick() {

        //Aniimations
        animStanding.tick();
        animRight.tick();
        //input
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
    private  void getInput(){


        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove = speed;


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width, height, null);

//        g.setColor(Color.RED);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//                bounds.width, bounds.height);
    }
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove< 0 ){
            return  animStanding.getCurrentFrame();

        }else if(xMove > 0){
            return  animRight.getCurrentFrame();

        }else if(yMove < 0 ){
            return animRight.getCurrentFrame();

        }else if(yMove > 0){

            return animStanding.getCurrentFrame();
        }

        return  animStanding.getCurrentFrame();
    }
}
