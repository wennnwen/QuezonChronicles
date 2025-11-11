package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class BakeryGremlin extends Enemy{

    public BakeryGremlin(){
        setName("Bakery Gremlin");
        setMaxHp(80);
        setHp(80);
        setAttackPower(10);
        setDefense(6);
        setSpeed(8);

        setExpReward(55);

        // Possible loot
        setPossibleLoot(new Item[]{new Pinagong(), new Budin()});
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