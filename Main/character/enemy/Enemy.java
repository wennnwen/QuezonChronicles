package Main.character.enemy;

import Main.Character.Character;
import Main.Character.Player.*;
import Main.Items.*;

public class Enemy extends Character {

    private int expReward;
    private Item[] possibleLoot;

    public abstract void enemyMove(Player player);

    public Item dropLoot() {
        if (possibleLoot == null || possibleLoot.length == 0) {
            return null;
        }

        double roll = Math.random();
        if (roll < 0.4) {
            System.out.println(getName() + " dropped " + possibleLoot[0].getName() + "!");
            return possibleLoot[0];
        }
        else if (roll < 0.8 && roll >= 0.4) {
            System.out.println(getName() + " dropped " + possibleLoot[1].getName() + "!");
            return possibleLoot[1];
        }
        else {
            System.out.println(getName() + " dropped nothing.");
            return null;
        }
    }

    public int getExpReward() {
        return expReward;
    }
}
