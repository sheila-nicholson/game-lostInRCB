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

public class FailedExam extends Enemy {

    protected FailedExam(int speed){
        super(speed); // set speed to lowest amount of all three bosses
        // speed and damagePoints inherited from Enemy and will vary
    }

    // call scoreModifier

}
