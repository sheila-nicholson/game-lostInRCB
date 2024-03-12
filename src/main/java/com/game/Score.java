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

    void  setScore(int score);
    int getScore();
    boolean checkScore();
    void addScore(int score);

    // per UML: add HUD

    /*
     *  private Map currentMap;
     *  private HUD currentHUD;
     *  private int currentScore;
     *  private time timeElapsed; <- typo in UML?
     * 
     *  public HUD() {
     *  
     *  }
     * 
     *  public void displayHUD() {
     * 
     * 
     *  }
     */

     // per UML: add timeElapsed

     /*
      * private int secondsElapsed; 
      *
      * public timeElapsed() {
      *  
      * }
      *  
      * public void setTime() { // setter
      *
      * }
      *
      * public int getTime() { // getter
      *
      * }
      *
      *
      */

}