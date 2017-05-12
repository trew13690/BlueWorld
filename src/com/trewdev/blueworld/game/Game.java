package com.trewdev.blueworld.game;

import com.trewdev.blueworld.graphics.Assets;
import com.trewdev.blueworld.graphics.Display;
import com.trewdev.blueworld.graphics.GameCamera;
import com.trewdev.blueworld.graphics.states.*;
import com.trewdev.blueworld.input.KeyManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by trew1 on 5/9/2017.
 */
public class Game implements Runnable {

    private Display display;
    private int width, height;
    public String title;
    private boolean running;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;


    //States


    private State gameState;
    private State menuState;
    private State inGameMenuState;
    private State characterCreationState;


    private KeyManager keyManager;
    private GameCamera gameCamera;

    public Game(String title, int width, int height) {

        this.width = width;
        this.height = height;
        this.title = title;
        this.keyManager = new KeyManager();


    }

    private void init() {

        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameCamera = new GameCamera(this,0,0);


        gameState = new GameState(this);
        menuState = new MenuState(this);
        inGameMenuState = new InGameMenuState(this);
        characterCreationState = new ChararcterCreationState(this);

        State.setState(gameState);


    }


    private void tick() {

        keyManager.tick();
        if (State.getState() != null) {

            State.getState().tick();
        }

    }

    private void render() {

        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);


        if (State.getState() != null) {

            State.getState().render(g);
        }


        bs.show();
        g.dispose();


    }

    @Override
    public void run() {

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;


        while (running) {

            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;


            }


        }

        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();


    }

    public GameCamera getGameCamera(){

        return gameCamera;


    }

    public int getWidth(){
        return width;
    }
    public  int getHeight(){
        return height;
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
