package com.game.Tile;

import com.game.Items.PunishmentItem;

import java.awt.*;

/**
 * Represents a tile that has negative consequences when interacted with by the player.
 * <p>
 * This class extends {@link Tile} to create tiles that, when stepped on, can trigger
 * a punishment effect through an associated {@link PunishmentItem}. These tiles may
 * influence the game state or the player's performance negatively.
 */
public class BadTile extends Tile {
    private PunishmentItem tileItem;
    private boolean tileSteppability;

/*    BadTile(PunishmentItem param_item, Image param_image, int param_X, int param_y){
        this.tileItem = param_item;
        setPosition(param_X,param_y);
        setTileSprite(param_image);
    }*/

    /**
     * Retrieves the punishment item associated with this tile.
     * <p>
     * This method allows access to the {@link PunishmentItem} associated with this tile,
     * enabling the application of its effects when the tile is interacted with.
     *
     * @return the {@link PunishmentItem} associated with this tile.
     */
    public PunishmentItem getTileItem() {
        return this.tileItem;
    }

    /**
     * Checks if the tile can be stepped on.
     * <p>
     * This method indicates whether the tile can be physically occupied or interacted with
     * by the player, affecting navigation and gameplay strategy.
     *
     * @return {@code true} if the tile can be stepped on, {@code false} otherwise.
     */
    public boolean tileSteppable() {
        return this.tileSteppability;
    }

}
