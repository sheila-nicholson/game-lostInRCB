/*
 * PileOfBooks.java
 * 
 * Class Description: Primary punishment which incurs a 5 point penalty should the player come in contact.
 *
 * Authors: [put your names here] + Sheila ???
 * Last modified on: March 6, 2024 1:13 AM
 */


package com.game.Items;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import com.game.Character.Hero;
import com.game.GamePanel.GamePanel;

public class PileOfBooks extends PunishmentItem {

    private int damagePoints = -5;

    /**
     * Constructor
     */
    public PileOfBooks(GamePanel gamePanel) {
        this.punishmentType = PunishmentType.BOOKS;
        name = "PileOfBooks";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Items/PileOfBooks.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public int getScoreModifier(){
        return this.damagePoints;
    }

    // play animation? play sound?

    public void collisionAction(Hero hero) {

        hero.addScore(damagePoints);      // adds -5 to hero score
    }

    public void updateItemState() {

    }

}
