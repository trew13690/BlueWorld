package com.trewdev.blueworld.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by trew1 on 5/11/2017.
 */
public class KeyManager implements KeyListener {
    private boolean[] keys;
    public  boolean up,down, left, right;

    public KeyManager() {

        keys = new boolean[256];
    }


    public  void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
    }
    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("Key is pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
