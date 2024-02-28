/*
 * Score.java
 * 
 * Class Description: [to come Wednesday evening by Jonas]
 *
 * Authors: [put your names here]
 * Last modified on: February 28 4:48 AM
 */


package com.game;


//change this class as an interface
//the HUD class can get the score through hero
public interface Score {
    void setScore(int score);
    int getScore();
    boolean checkScore(); // What does this method intend to check?
    // it checks (I think) whether it is negative or not, if the boolean is I think true then the character loses - JL
}