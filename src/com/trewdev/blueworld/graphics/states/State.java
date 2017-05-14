package com.trewdev.blueworld.graphics.states;

import com.trewdev.blueworld.game.Game;
import com.trewdev.blueworld.game.Handler;

import java.awt.*;

/**
 * Created by trew1 on 5/11/2017.
 */
public abstract class State {


    private static State currentState = null;

    public static void setState(State state){
        currentState = state;

    }

    public static State getState(){
        return currentState;
    }


    //CLASS


    protected Handler handler;
    public  State(Handler handler){
        this.handler = handler;
    }
    public abstract void tick();
    public abstract  void render(Graphics g);



}



