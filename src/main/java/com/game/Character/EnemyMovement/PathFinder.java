package com.game.Character.EnemyMovement;

import com.game.GamePanel.GamePanel;

import java.util.ArrayList;

public class PathFinder {
    GamePanel gamePanel;
    Node[][] node;
    ArrayList<Node> openList = new ArrayList<>();
    public ArrayList<Node> pathList = new ArrayList<>();
    Node startNode, goalNode, currentNode;
    boolean goalReached = false;
    int step = 0;

    public PathFinder(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        instantiateNode();
    }

    public void instantiateNode(){
        node = new Node[gamePanel.maxScreenCol][gamePanel.maxScreeRow];

        int c = 0;
        int r = 0;

        while(c < gamePanel.maxScreenCol && r < gamePanel.maxScreeRow){
            node[c][r] = new Node(c,r);
            c++;
            if(c == gamePanel.maxScreenCol){
                c = 0;
                r++;
            }
        }
    }

    public  void resetNodes(){
        int c = 0;
        int r = 0;

        while(c < gamePanel.maxScreenCol && r < gamePanel.maxScreeRow){
            node[c][r].open = false;
            node[c][r].checked = false;
            node[c][r].solid = false;
            c++;
            if(c == gamePanel.maxScreenCol){
                c = 0;
                r++;
            }

        }

        openList.clear();
        pathList.clear();
        goalReached = false;
        step = 0;

    }

    public void setNode(int startCol, int startRow, int goalCol, int goalRow, Character character){
        resetNodes();

        startNode = node[startCol][startRow];
        currentNode = startNode;
        goalNode = node[goalCol][goalRow];
        openList.add(currentNode);

        int col = 0;
        int row = 0;
        int tileNum = 0;

        while(col < gamePanel.maxScreenCol && row < gamePanel.maxScreeRow){

            //set solid node and check tiles
            tileNum = gamePanel.tileM.getMapTileNum()[col][row];

           //set cost
           if(gamePanel.tileM.getTile()[tileNum].collision){
                node[col][row].solid = true;
           }

           getCost(node[col][row]);
           col++;

           if(col == gamePanel.maxScreenCol){
               col = 0;
               row++;
           }
        }
    }

    public void getCost(Node node){//not finished

    }





}
