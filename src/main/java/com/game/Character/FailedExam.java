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

    protected FailedExam(int speed, GamePanel gamePanel){
        super(speed,gamePanel);
    }

    protected void setDefaultPosition(){
        this.setPosition(0,70);
        currentDirection = Direction.RIGHT;
        lastDirection = Direction.RIGHT;
    }

    public void getImage() {//pic is temp
        rightImage = setImage("/Enemy/Zombie_right");
        leftImage = setImage("/Enemy/Zombie_right");
    }

}
