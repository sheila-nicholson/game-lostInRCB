package com.game.Tile;

/**
 * Represents a tile that benefits the player when interacted with.
 * <p>
 * This class extends {@link Tile} to provide tiles that can have positive effects when
 * stepped on or interacted with by the player. Properties of the tile, such as its
 * steppability and whether it marks the end of a level, determine its impact on gameplay.
 */
public class GoodTile extends Tile {

    /**
     * Constructs a GoodTile with specified properties.
     * <p>
     * Initializes a tile with properties indicating whether it can be stepped on and
     * whether it signifies the end of a level, thus affecting gameplay and player progression.
     *
     * @param tileSteppability Indicates if the tile can be stepped on.
     * @param isLevelEndBool Indicates if stepping on the tile should trigger the end of the level.
     */
    public GoodTile(boolean tileSteppability, boolean isLevelEndBool){
        this.tileSteppability = tileSteppability;
        this.isLevelEndBool = isLevelEndBool;
    };


}
