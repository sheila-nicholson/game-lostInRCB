package com.game.Tile;

import java.awt.*;

/**
 * Represents a neutral tile within the game environment.
 * <p>
 * This class extends {@link Tile} to provide basic ground or path tiles that do not
 * have any special effects on the player. It is primarily used for creating the
 * walkable areas of the game world where no additional interactions occur.
 */
public class NeutralTile extends Tile {

    private Image tileSprite;
    private boolean tileSteppability;

/*    NeutralTile(Image param_sprite, int param_X, int param_y){
        setTileSprite(param_sprite);
        setPosition(param_X,param_y);
    }*/

    /**
     * Checks if the tile can be stepped on.
     * <p>
     * This method is used to determine whether the tile can be physically occupied
     * or interacted with by the player, affecting navigation and game strategy.
     *
     * @return {@code true} if the tile can be stepped on, {@code false} otherwise.
     */
    public boolean tileSteppable() {
        return this.tileSteppability;
    }
}
