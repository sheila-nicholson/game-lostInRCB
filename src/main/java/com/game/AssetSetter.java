package com.game;

import com.game.GamePanel.GamePanel;
import com.game.Items.*;
public class AssetSetter {

    GamePanel gamePanel;

    public AssetSetter(GamePanel gamepanel) {
        this.gamePanel = gamepanel;

    }

    // Setting original position of objects on the map
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
