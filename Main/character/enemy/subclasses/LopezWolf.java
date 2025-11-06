package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;

public class LopezWolf extends Enemy{

    public LopezWolf(){
        setName("Lopez Wolf");
        setMaxHp(30);
        setHp(30);
        setAttackPower(6);
        setDefense(5);
        setSpeed(12);

        // Experience reward
        expReward = 40;

        //Possible Loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new Tinuto();
        possibleLoot[1] = new PugonCoffee();
    }

    @Override
    public void enemyMove(Player player) {
    System.out.println(getName() + " bites " + player.getName() + " with its strong jaws!");

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