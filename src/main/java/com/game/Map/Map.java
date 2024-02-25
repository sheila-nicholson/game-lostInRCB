package com.game;

import java.util.ArrayList;

public class Map {
    private ArrayList<Tile>[][] tileGrid = new ArrayList[50][50];
    private ArrayList<Wall> Walls = new ArrayList<Wall>();
    private Hero Player;
    private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

    Map(ArrayList<Tile>[][] tileGrid){
        this.tileGrid = tileGrid;
    }
}
