package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class BakeryGremlin extends Enemy{

    public BakeryGremlin(){
        setName("Bakery Gremlin");
        setMaxHp(50);
        setHp(50);
        setAttackPower(12);
        setDefense(7);
        setSpeed(10);

        // Experience reward
        expReward = 25;

        //Possible Loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new Pinagong();
        possibleLoot[1] = new Budin();
    }

    @Override
    public void enemyMove(Player player) {
    System.out.println(getName() + " throws a Pinagong at " + player.getName() + "!");

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