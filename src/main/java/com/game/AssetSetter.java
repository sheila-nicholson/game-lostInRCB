package com.game;

import com.game.GamePanel.GamePanel;
import com.game.Items.*;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Responsible for setting and positioning items in the game world.
 * <p>
 * This class initializes game items, such as beds, papers, coffee, books, and vortexes,
 * and assigns them to specific positions within the game environment. It is used to
 * populate the game world with interactive and collectible items that the player can
 * interact with or collect during gameplay.
 */

public class AssetSetter {

    GamePanel gamePanel;
    private String mapDifficulty;

    /**
     * Constructs an AssetSetter associated with a specific game panel.
     * <p>
     * Initializes the AssetSetter with a reference to the {@link GamePanel}, allowing
     * it to place items within the context of the current game environment.
     *
     * @param gamepanel The game panel to which the items will be added.
     */
    public AssetSetter(GamePanel gamepanel) {
        this.gamePanel = gamepanel;

    }


    // Setting original position of objects on the map
    /**
     * Initializes and positions game items on the map.
     * <p>
     * Creates instances of various item types and sets their initial positions within
     * the game world. This method is called to populate the game environment with
     * interactive or collectible items, enhancing the gameplay experience.
     */
    public void setObject(String mapDifficulty) {

        this.mapDifficulty = mapDifficulty;

        if (mapDifficulty == "Easy") {          // Easy map difficulty has 3 of all types of items - total = 15

            Item[] item = gamePanel.getItem();

            item[0] = new Bed(gamePanel);
            item[0].setPosition(22, 1);

            item[1] = new Bed(gamePanel);
            item[1].setPosition(5, 1);

            item[2] = new Bed(gamePanel);
            item[2].setPosition(1, 10);

            item[3] = new APlusPaper(gamePanel);
            item[3].setPosition(2, 11);

            item[4] = new APlusPaper(gamePanel);
            item[4].setPosition(17, 16);

            item[5] = new APlusPaper(gamePanel);
            item[5].setPosition(26, 1);

            item[6] = new Coffee(gamePanel);
            item[6].setPosition(2, 3);

            item[7] = new Coffee(gamePanel);
            item[7].setPosition(14, 5);

            item[8] = new Coffee(gamePanel);
            item[8].setPosition(19, 11);

            item[9] = new PileOfBooks(gamePanel);
            item[9].setPosition(4, 6);

            item[10] = new PileOfBooks(gamePanel);
            item[10].setPosition(19, 5);

            item[11] = new PileOfBooks(gamePanel);
            item[11].setPosition(16, 11);

            item[12] = new Vortex(gamePanel);
            item[12].setPosition(22, 6);

            item[13] = new Vortex(gamePanel);
            item[13].setPosition(25, 14);

            item[14] = new Vortex(gamePanel);
            item[14].setPosition(6, 15);

        } else if (mapDifficulty == "Medium") {          // Medium map difficulty has 4 of all punishment items, 3 of each reward item  = 17 total

            Item[] item = gamePanel.getItem();

            item[0] = new Bed(gamePanel);
            item[0].setPosition(6, 4);

            item[1] = new Bed(gamePanel);
            item[1].setPosition(13, 15);

            item[2] = new Bed(gamePanel);
            item[2].setPosition(22, 1);

            item[3] = new APlusPaper(gamePanel);
            item[3].setPosition(1, 7);

            item[4] = new APlusPaper(gamePanel);
            item[4].setPosition(11, 2);

            item[5] = new APlusPaper(gamePanel);
            item[5].setPosition(20, 16);

            item[6] = new Coffee(gamePanel);
            item[6].setPosition(8, 10);

            item[7] = new Coffee(gamePanel);
            item[7].setPosition(1, 15);

            item[8] = new Coffee(gamePanel);
            item[8].setPosition(24, 6);

            item[9] = new PileOfBooks(gamePanel);
            item[9].setPosition(2, 4);

            item[10] = new PileOfBooks(gamePanel);
            item[10].setPosition(16, 5);

            item[11] = new PileOfBooks(gamePanel);
            item[11].setPosition(7, 14);

            item[12] = new PileOfBooks(gamePanel);
            item[12].setPosition(24, 11);

            item[13] = new Vortex(gamePanel);
            item[13].setPosition(5, 11);

            item[14] = new Vortex(gamePanel);
            item[14].setPosition(8, 2);

            item[15] = new Vortex(gamePanel);
            item[15].setPosition(15, 10);

            item[16] = new Vortex(gamePanel);
            item[16].setPosition(26, 14);


        } else if (mapDifficulty == "Hard") {             // Hard map difficulty has 5 of all punishment items, 2 of each reward item      = 16 total

            Item[] item = gamePanel.getItem();

            item[0] = new Bed(gamePanel);
            item[0].setPosition(20, 4);

            item[1] = new Bed(gamePanel);
            item[1].setPosition(6, 13);

            item[2] = new APlusPaper(gamePanel);
            item[2].setPosition(18, 16);

            item[3] = new APlusPaper(gamePanel);
            item[3].setPosition(26, 8);

            item[4] = new Coffee(gamePanel);
            item[4].setPosition(4, 5);

            item[5] = new Coffee(gamePanel);
            item[5].setPosition(14, 8);

            item[6] = new PileOfBooks(gamePanel);
            item[6].setPosition(1, 3);

            item[7] = new PileOfBooks(gamePanel);
            item[7].setPosition(5, 7);

            item[8] = new PileOfBooks(gamePanel);
            item[8].setPosition(15, 11);

            item[9] = new PileOfBooks(gamePanel);
            item[9].setPosition(23, 6);

            item[10] = new PileOfBooks(gamePanel);
            item[10].setPosition(22, 12);

            item[11] = new Vortex(gamePanel);
            item[11].setPosition(10, 7);

            item[12] = new Vortex(gamePanel);
            item[12].setPosition(4, 11);

            item[13] = new Vortex(gamePanel);
            item[13].setPosition(12, 15);

            item[14] = new Vortex(gamePanel);
            item[14].setPosition(14, 5);

            item[15] = new Vortex(gamePanel);
            item[15].setPosition(26, 15);

        } else if (mapDifficulty == "Infinite") {             // Hard map difficulty has 5 of all items types      = 25 total // all items are spawned into random locations when map is initiated

            Item[] item = gamePanel.getItem();

            int newRowPos;
            int newColPos;
            //boolean validPosition = false;

            // Spawn Bed items
            for (int i = 0; i < 5; i++) {

                boolean validPosition = false;


                while (!validPosition) {

                    boolean floorPosition = false;
                    boolean itemOccupy = false;

                    newRowPos = ThreadLocalRandom.current().nextInt(0, 18);
                    newColPos = ThreadLocalRandom.current().nextInt(0, 28);
                    int tileNum = gamePanel.tileM.getMapTileNum()[newColPos][newRowPos];
                    Position checkPosValid = new Position(newColPos * 48, newRowPos * 48);
                    floorPosition = gamePanel.tileM.getTile()[tileNum].getTileType() == "floor";
                    itemOccupy = !(gamePanel.collisionChecker.isTileOccupied(item, checkPosValid));

                    if (floorPosition && itemOccupy) {

                        validPosition = true;
                        item[i] = new Bed(gamePanel);
                        item[i].setPosition(newColPos, newRowPos);
                    }
                }
            }

            // Spawn APlusPaper items
            for (int i = 0; i < 5; i++) {

                boolean validPosition = false;

                while (!validPosition) {

                    boolean floorPosition = false;
                    boolean itemOccupy = false;


                    newRowPos = ThreadLocalRandom.current().nextInt(0, 18);
                    newColPos = ThreadLocalRandom.current().nextInt(0, 28);
                    int tileNum = gamePanel.tileM.getMapTileNum()[newColPos][newRowPos];
                    Position checkPosValid = new Position(newRowPos * 48, newColPos * 48);
                    floorPosition = gamePanel.tileM.getTile()[tileNum].getTileType() == "floor";
                    itemOccupy = !(gamePanel.collisionChecker.isTileOccupied(item, checkPosValid));

                    if (floorPosition && itemOccupy) {
                        validPosition = true;
                        item[i + 5] = new APlusPaper(gamePanel);
                        item[i + 5].setPosition(newColPos, newRowPos);
                    }
                }
            }

            // Spawn Coffee items
            for (int i = 0; i < 5; i++) {

                boolean validPosition = false;

                while (!validPosition) {

                    boolean floorPosition = false;
                    boolean itemOccupy = false;


                    newRowPos = ThreadLocalRandom.current().nextInt(0, 18);
                    newColPos = ThreadLocalRandom.current().nextInt(0, 28);
                    int tileNum = gamePanel.tileM.getMapTileNum()[newColPos][newRowPos];
                    Position checkPosValid = new Position(newRowPos * 48, newColPos * 48);
                    floorPosition = gamePanel.tileM.getTile()[tileNum].getTileType() == "floor";
                    itemOccupy = !(gamePanel.collisionChecker.isTileOccupied(item, checkPosValid));

                    if (floorPosition && itemOccupy) {
                        validPosition = true;
                        item[i + 10] = new Coffee(gamePanel);
                        item[i + 10].setPosition(newColPos, newRowPos);
                    }
                }
            }

            // Spawn PileOfBooks items
            for (int i = 0; i < 5; i++) {

                boolean validPosition = false;

                while (!validPosition) {

                    boolean floorPosition = false;
                    boolean itemOccupy = false;

                    newRowPos = ThreadLocalRandom.current().nextInt(0, 18);
                    newColPos = ThreadLocalRandom.current().nextInt(0, 28);
                    int tileNum = gamePanel.tileM.getMapTileNum()[newColPos][newRowPos];
                    Position checkPosValid = new Position(newRowPos * 48, newColPos * 48);
                    floorPosition = gamePanel.tileM.getTile()[tileNum].getTileType() == "floor";
                    itemOccupy = !(gamePanel.collisionChecker.isTileOccupied(item, checkPosValid));

                    if (floorPosition && itemOccupy) {
                        validPosition = true;
                        item[i + 15] = new PileOfBooks(gamePanel);
                        item[i + 15].setPosition(newColPos, newRowPos);
                    }
                }
            }

            // Spawn Vortex items
            for (int i = 0; i < 5; i++) {

                boolean validPosition = false;

                while (!validPosition) {

                    boolean floorPosition = false;
                    boolean itemOccupy = false;

                    newRowPos = ThreadLocalRandom.current().nextInt(0, 18);
                    newColPos = ThreadLocalRandom.current().nextInt(0, 28);
                    int tileNum = gamePanel.tileM.getMapTileNum()[newColPos][newRowPos];
                    Position checkPosValid = new Position(newRowPos * 48, newColPos * 48);
                    floorPosition = gamePanel.tileM.getTile()[tileNum].getTileType() == "floor";
                    itemOccupy = !(gamePanel.collisionChecker.isTileOccupied(item, checkPosValid));

                    if (floorPosition && itemOccupy) {
                        validPosition = true;
                        item[i + 20] = new Vortex(gamePanel);
                        item[i + 20].setPosition(newColPos, newRowPos);
                    }
                }
            }
        }
    }
}
