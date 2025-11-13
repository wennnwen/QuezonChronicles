package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.printAlignmentHub.CenterHub;

public class HoneyGuardian extends Enemy {

    public HoneyGuardian() {
        setName("Honey Guardian");
        setMaxHp(80);
        setHp(80);
        setAttackPower(16); 
        setDefense(7);
        setSpeed(11);

        setExpReward(160);

        // Possible loot
        setPossibleLoot(new Item[]{new LambanogLecheFlan(), new MountainHoney()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " summons a horde of angry bees at " + player.getName() + "!";
        centerHub.printRightText(text);

        int attackPower = getAttackPower();

        // Critical hit mechanic
        double critChance = 0.2; // 20% chance
        if (Math.random() < critChance) {
            attackPower *= 2;
            centerHub.printRightText("Critical hit!");
        }

        // Deal damage
        player.takeDamage(attackPower);

        //poison
        double poisonChance = 0.3;
        if (Math.random() < poisonChance) {
            text = player.getName() + " is poisoned for 2 turns!";
            centerHub.printRightText(text);
            player.applyDebuff("Poison", 2);
        }
    }
}
