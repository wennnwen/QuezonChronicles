package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class LucenaPirate extends Enemy{

    public LucenaPirate(){
        setName("Lucena Pirate");
        setMaxHp(100);
        setHp(100);
        setAttackPower(17);
        setDefense(10);
        setSpeed(12);

        setExpReward(180);

        // Possible loot
        setPossibleLoot(new Item[]{new Chami(), new CocoJam()});
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