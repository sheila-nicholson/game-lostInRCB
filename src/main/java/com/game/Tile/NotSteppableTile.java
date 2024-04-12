package com.game.Tile;

public class NotSteppableTile extends Tile{
    public NotSteppableTile(){
        this.tileSteppability = false;
        this.isLevelEndBool = false;
    }
}
