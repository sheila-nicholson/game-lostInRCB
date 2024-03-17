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

public class Raccoon extends Enemy {
    protected Raccoon(int speed, GamePanel gamePanel){
        super(speed,gamePanel);
    }

    protected void setDefaultPosition(){
        this.setPosition(0,70);
        currentDirection = Direction.RIGHT;
        lastDirection = Direction.RIGHT;
    }

    public void getImage() {//pic is temp
        rightImage = setImage("/Enemy/Bear_right");
        leftImage = setImage("/Enemy/Bear_right");
    }


}
