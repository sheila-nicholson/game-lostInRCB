package com.game.Character.EnemyMovement;

import com.game.Character.Character;
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

        int xDistance = Math.abs(node.col-startNode.col);
        int yDistance = Math.abs(node.row-startNode.row);
        node.gCost = xDistance + yDistance;

        xDistance = Math.abs(node.col-startNode.col);
        yDistance = Math.abs(node.row-startNode.row);
        node.hCost = xDistance + yDistance;

        node.fCost = node.gCost + node.hCost;

    }

    public boolean search() {
        while (goalReached == false && step < 500) {
            int col = currentNode.col;
            int row = currentNode.row;

            currentNode.checked = true;
            openList.remove(currentNode);

            if (row - 1 >= 0) {
                openNode(node[col][row - 1]);

            }
            if (row - 1 >= 0) {
                openNode(node[col - 1][row]);

            }
            if (row - 1 >= 0) {
                openNode(node[col][row + 1]);

            }
            if (row - 1 >= 0) {
                openNode(node[col + 1][row]);

            }

            //find best node
            int bestNodeIndex = 0;
            int bestNodeCost = 999;

            for (int i = 0; i < openList.size(); i++) {
                //check if this node's f cost is better
                if (openList.get(i).fCost < bestNodeCost) {
                    bestNodeIndex = i;
                    bestNodeCost = openList.get(i).fCost;

                    //if f cost is equal, check the g cost
                } else if (openList.get(i).fCost == bestNodeCost) {
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                        bestNodeIndex = i;
                    }
                }

                //if ther is no node in the openlist, end the loop
                if (openList.size() == 0) {
                    break;
                }

                //after the loop, openList[bestNodeIndex] is the next step => currentNode
                currentNode = openList.get(bestNodeIndex);

                if (currentNode == goalNode) {
                    goalReached = true;
                    trackThePath();

                }

                step++;
            }

        }
            return goalReached;
    }

    public void trackThePath(){
         Node current = goalNode;
         while(current != startNode){
             pathList.add(0,current);
             current = current.parent;
         }
    }

    public void openNode(Node node){
        if (!node.open && !node.checked && !node.solid){
            node.open =true;
            node.parent = currentNode;
            openList.add(node);
        }
    }

}


