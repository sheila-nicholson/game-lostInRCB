/*
 * Raccoon.java
 * 
 * Class Description: Describing the easiest boss on the easiest level.
 *                    Slowest speed and lowest score penalty.
 *
 * Authors: [put your names here]
 * Last modified on: March 5, 12:00 PM
 */


package com.game.Character;

import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;

import java.security.PublicKey;

public class Bear extends Enemy {

    public Bear(int speed, GamePanel gamePanel){
        super(speed,gamePanel);
        this.setPosition(7*gamePanel.tileSize,6*gamePanel.tileSize);//temp
    }

    public void getImage() {//pic is temp
        rightImage = setImage("/Enemy/Bear_right");
        leftImage = setImage("/Enemy/Bear_right");
    }

}
