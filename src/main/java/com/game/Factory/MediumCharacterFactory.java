package com.game.Factory;

import com.game.Character.Enemy;
import com.game.Character.Hero;
import com.game.Character.ZoombieProfessor;

public class MediumCharacterFactory extends CharacterFactory {
    public Hero createHero() {
        return Hero.getInstance(200); //temp speed
    }
    public Enemy createEnemy() {
        return ZoombieProfessor.getInstance(100); //temp speed
    }
}
