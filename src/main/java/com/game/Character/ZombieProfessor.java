/*
 * ZombieProfessor.java
 * 
 * Class Description: Describing the medium boss on the medium level.
 *                    Medium speed and medium score penalty.
 *
 * Authors: [put your names here]
 * Last modified on: March 5, 12:00 PM
 */


package com.game.Character;
import com.game.GamePanel.GamePanel;
import com.game.Key.Direction;

public class ZombieProfessor extends Enemy {

    public ZombieProfessor (int speed, GamePanel gamePanel){
        super(speed, gamePanel);
    }


    public void getImage() {
        rightImage = setImage("/Enemy/Zombie_right");
        leftImage = setImage("/Enemy/Zombie_right");
    }
}
