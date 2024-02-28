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
    boolean checkScore();
    void addScore(int score);
    void minusScore(int score);

}