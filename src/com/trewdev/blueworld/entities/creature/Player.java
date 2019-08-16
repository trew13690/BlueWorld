package com.trewdev.blueworld.entities.creature;


import com.trewdev.blueworld.ui.Inventory;
import com.trewdev.blueworld.entities.Entity;
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

    private Animation animRight;
    private Animation animLeft;
    private Animation animUp;
    private Animation animDown;
    private Animation animStanding;


    private Inventory inventory;


    //Attack Timer
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;

    public Player(Handler handler, float x, float y) {
        super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 16;
        bounds.y = 64;
        bounds.width = 46 ;
        bounds.height = 40;


        //Animations
        animStanding = new Animation(2000,Assets.red_character_standing);
        animRight = new Animation(150, Assets.red_character_right);
        animDown = new Animation(150, Assets.red_character_down);
        animLeft = new Animation(150, Assets.red_character_left);
        animUp = new Animation(150, Assets.red_character_up);


        inventory = new Inventory(handler);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void tick() {

        //Aniimations

        animRight.tick();
        animLeft.tick();
        animUp.tick();
        animDown.tick();
        animStanding.tick();
        //input
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);


        //Attack
        checkAttack();

        inventory.tick();

    }
    private void checkAttack() {

        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();

        if(attackTimer < attackCooldown)
            return;
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if (handler.getKeyManager().aUp) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        } else if (handler.getKeyManager().aDown) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - cb.height;
        } else if (handler.getKeyManager().aLeft) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else if (handler.getKeyManager().aRight) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else {

            return;
        }
        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0, 0).intersects(ar))
                e.hurt(1);
            return;

        }
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
        if(handler.getKeyManager().delKey)
            System.exit(0);

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width, height, null);

//        g.setColor(Color.RED);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//               (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//               bounds.width, bounds.height);
    }

    public void postRender(Graphics g){
        inventory.render(g);


    }
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0 ){
            return animLeft.getCurrentFrame();

        }else if(xMove > 0){
            return animRight.getCurrentFrame();

        }else if(yMove < 0 ){
            return animUp.getCurrentFrame();

        }else if(yMove > 0){

            return animDown.getCurrentFrame();
        }
        if(xMove == 0 && yMove == 0) {
            return animStanding.getCurrentFrame();
        }
        return Assets.red_character_static;
    }

    @Override
    public void die(){}
}
