package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;

public class LucenaPirate extends Enemy{

    public LucenaPirate(){
        setName("Lucena Pirate");
        setMaxHp(30);
        setHp(30);
        setAttackPower(6);
        setDefense(6);
        setSpeed(10);

        // Experience reward
        expReward = 40;

        //Possible Loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new Chami();
        possibleLoot[1] = new CocoJam();
    }

    @Override
    public void enemyMove(Player player) {
    System.out.println(getName() + " lunges towards " + player.getName() + " fiercely!");

    int baseDamage = getAttackPower();
    if (baseDamage < 0) baseDamage = 0;

    // Critical hit mechanic
    double critChance = 0.2;
    double critRoll = Math.random();
    if (critRoll < critChance) {
        baseDamage *= 2;
        System.out.println("Critical hit!");
    }

        player.takeDamage(baseDamage);
    }
}