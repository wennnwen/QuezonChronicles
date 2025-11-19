package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class PortRat extends Enemy{

    public PortRat(){
        setName("Port Rat");
        // Early-mid game enemy - Town 2
        setMaxHp(60);
        setHp(60);
        setAttackPower(12);
        setDefense(4);
        setSpeed(13);

        setExpReward(40);

        // Possible loot
        setPossibleLoot(new Item[]{new Chami(), new CocoJam()});
    }

    @Override
    public void enemyMove(Player player) {
    String text = getName() + " swiftly bites the " + player.getName() + "!";
    centerHub.printRightTextWithTypeWriter(text);

    int baseDamage = getAttackPower();
    if (baseDamage < 0) baseDamage = 0;

    // Critical hit mechanic
    double critChance = 0.2;
    double critRoll = Math.random();
    if (critRoll < critChance) {
        baseDamage *= 2; // Critical hit doubles damage
        centerHub.printRightTextWithTypeWriter(textColor.RED + "Critical hit!" + textColor.RESET);
    }

        player.takeDamage(baseDamage);
    }
}