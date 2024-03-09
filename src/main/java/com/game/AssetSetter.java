package com.game;

import com.game.GamePanel.GamePanel;
import com.game.Items.Bed;

public class AssetSetter {

    GamePanel gamePanel;

    public AssetSetter(GamePanel gamepanel) {
        this.gamePanel = gamepanel;

    }

    public void setObject() {

        gamePanel.item[0] = new Bed();
        gamePanel.item[0].worldX = 23 * gamePanel.tileSize;     // 23 is arbitrary change later
        gamePanel.item[0].worldY = 7 * gamePanel.tileSize;      // 7 is arbitrary change later

        gamePanel.item[1] = new Bed();
        gamePanel.item[1].worldX = 23 * gamePanel.tileSize;     // 23 is arbitrary change later
        gamePanel.item[1].worldY = 40 * gamePanel.tileSize;      // 40 is arbitrary change later
    }
}
