package com.game.Tile;

public class EndTile extends Tile{
    public EndTile(){
        this.tileSteppability = false;
        this.isLevelEndBool = true;
    }
}
