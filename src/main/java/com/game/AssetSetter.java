package com.game;

import com.game.GamePanel.GamePanel;
import com.game.Items.*;

/**
 * Responsible for setting and positioning items in the game world.
 * <p>
 * This class initializes game items, such as beds, papers, coffee, books, and vortexes,
 * and assigns them to specific positions within the game environment. It is used to
 * populate the game world with interactive and collectible items that the player can
 * interact with or collect during gameplay.
 */
public class AssetSetter {

    GamePanel gamePanel;

    /**
     * Constructs an AssetSetter associated with a specific game panel.
     * <p>
     * Initializes the AssetSetter with a reference to the {@link GamePanel}, allowing
     * it to place items within the context of the current game environment.
     *
     * @param gamepanel The game panel to which the items will be added.
     */
    public AssetSetter(GamePanel gamepanel) {
        this.gamePanel = gamepanel;

    }

    /**
     * Initializes and positions game items on the map.
     * <p>
     * Creates instances of various item types and sets their initial positions within
     * the game world. This method is called to populate the game environment with
     * interactive or collectible items, enhancing the gameplay experience.
     */
    public void setObject() {
        Item[] item = gamePanel.getItem();

        item[0] = new Bed(gamePanel);
        item[0].setPosition(22 * gamePanel.tileSize, 1 * gamePanel.tileSize);


        item[1] = new Bed(gamePanel);
        item[1].setPosition(6 * gamePanel.tileSize, 3 * gamePanel.tileSize);

        item[2] = new Bed(gamePanel);
        item[2].setPosition(13 * gamePanel.tileSize, 13 * gamePanel.tileSize);

        item[3] = new APlusPaper(gamePanel);
        item[3].setPosition(2 * gamePanel.tileSize, 11 * gamePanel.tileSize);

        item[4] = new APlusPaper(gamePanel);
        item[4].setPosition(17 * gamePanel.tileSize, 16 * gamePanel.tileSize);

        item[5] = new APlusPaper(gamePanel);
        item[5].setPosition(26 * gamePanel.tileSize, 1 * gamePanel.tileSize);

        item[6] = new Coffee(gamePanel);
        item[6].setPosition(2 * gamePanel.tileSize, 3 * gamePanel.tileSize);

        item[7] = new Coffee(gamePanel);
        item[7].setPosition(14 * gamePanel.tileSize, 5 * gamePanel.tileSize);

        item[8] = new Coffee(gamePanel);
        item[8].setPosition(19 * gamePanel.tileSize, 11 * gamePanel.tileSize);

        item[9] = new PileOfBooks(gamePanel);
        item[9].setPosition(2 * gamePanel.tileSize, 14 * gamePanel.tileSize);

        item[10] = new PileOfBooks(gamePanel);
        item[10].setPosition(11 * gamePanel.tileSize, 16 * gamePanel.tileSize);

        item[11] = new PileOfBooks(gamePanel);
        item[11].setPosition(24 * gamePanel.tileSize, 3 * gamePanel.tileSize);

        item[12] = new Vortex(gamePanel);
        item[12].setPosition(22 * gamePanel.tileSize, 6 * gamePanel.tileSize);

        item[13] = new Vortex(gamePanel);
        item[13].setPosition(11 * gamePanel.tileSize, 8 * gamePanel.tileSize);

        item[14] = new Vortex(gamePanel);
        item[14].setPosition(13 * gamePanel.tileSize, 3 * gamePanel.tileSize);
    }


}
