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
public class ZombieProfessor extends Enemy {
    protected ZombieProfessor (int speed){
        super(speed);
        // set speed to lowest amount of all three bosses
        // speed and damagePoints inherited from Enemy and will vary
    }

    // call scoreModifier
}
