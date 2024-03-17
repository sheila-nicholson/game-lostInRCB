/*
 * FailedExam.java
 * 
 * Class Description: Describing the hardest boss on the hardest level.
 *                    Fastest speed and biggest score penalty.
 *
 * Authors: [put your names here]
 * Last modified on: March 5 11:27 AM
 */


package com.game.Character;

import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;

public class FailedExam extends Enemy {

    public FailedExam(int speed, GamePanel gamePanel){
        super(speed,gamePanel);
        this.setPosition(5*gamePanel.tileSize,4*gamePanel.tileSize);
    }

    public void getImage() {//pic is temp
        rightImage = setImage("/Enemy/FailedExam");
        leftImage = setImage("/Enemy/FailedExam");
    }

}
