package com.trewdev.blueworld.graphics.tiles;

import com.trewdev.blueworld.graphics.Assets;



/**
 * Created by trew1 on 5/11/2017.
 */
public class RockTile extends  Tile{

    public RockTile (int id) {
        super(Assets.rockTile, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }

}
