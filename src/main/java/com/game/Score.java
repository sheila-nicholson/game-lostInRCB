package com.game;


//change this class as an interface
//the HUD class can get the score through hero
public interface Score {
    void setScore(int score);
    int getScore();
    boolean checkScore(); // What does this method intend to check?
}