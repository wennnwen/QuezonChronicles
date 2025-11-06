package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class PortRat extends Enemy{

    public PortRat(){
        setName("Port Rat");
        setMaxHp(35);
        setHp(35);
        setAttackPower(8);
        setDefense(6);
        setSpeed(11);

        // Experience reward
        expReward = 30;

        //Possible Loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new Chami();
        possibleLoot[1] = new CocoJam();
    }

    @Override
    public void enemyMove(Player player) {
    System.out.println(getName() + " swiftly bites the " + player.getName() + "!");

    int baseDamage = getAttackPower();
    if (baseDamage < 0) baseDamage = 0;

    // Critical hit mechanic
    double critChance = 0.2;
    double critRoll = Math.random();
    if (critRoll < critChance) {
        baseDamage *= 2; // Critical hit doubles damage
        System.out.println("Critical hit!");
    }

        player.takeDamage(baseDamage);
    }
}