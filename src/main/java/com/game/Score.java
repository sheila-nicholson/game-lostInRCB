package com.game;


//change this class as an interface
//the HUD class can get the score through hero
interface Score {
    private currentScore;
    public void setScore(int score);
    public int getScore();
    public boolean checkScore();

}