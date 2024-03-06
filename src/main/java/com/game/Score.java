/*
 * Score.java
 * 
 * Class Description: Handles the score (point system) aspect of the game.
 *
 * Authors: [put your names here]
 * Last modified on: March 6, 2024 1:53 AM
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