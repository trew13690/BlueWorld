package com.trewdev.blueworld.mechanics.states;

import com.trewdev.blueworld.ui.UIImageButton;
import com.trewdev.blueworld.ui.UIManager;
import com.trewdev.blueworld.game.ClickListener;
import com.trewdev.blueworld.game.Handler;
import com.trewdev.blueworld.graphics.Assets;

import java.awt.*;

/**
 * Created by trew1 on 5/11/2017.
 */
public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManger().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.MenuButtons, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManger().setUiManager(null);
                State.setState(getState().handler.getGame().gameState);
            }
        }));


    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
