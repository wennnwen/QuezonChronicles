package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.printAlignmentHub.CenterHub;

public class PortRat extends Enemy{

    public PortRat(){
        setName("Port Rat");
        setMaxHp(45);
        setHp(45);
        setAttackPower(6);
        setDefense(3);
        setSpeed(13);

        setExpReward(20);

        // Possible loot
        setPossibleLoot(new Item[]{new Chami(), new CocoJam()});
    }

    @Override
    public void enemyMove(Player player) {
    String text = getName() + " swiftly bites the " + player.getName() + "!";
    centerHub.printRightText(text);

    int baseDamage = getAttackPower();
    if (baseDamage < 0) baseDamage = 0;

    // Critical hit mechanic
    double critChance = 0.2;
    double critRoll = Math.random();
    if (critRoll < critChance) {
        baseDamage *= 2; // Critical hit doubles damage
        centerHub.printRightText("Critical hit!");
    }

        player.takeDamage(baseDamage);
    }
}