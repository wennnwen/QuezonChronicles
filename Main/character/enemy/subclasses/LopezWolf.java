package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class LopezWolf extends Enemy{

    public LopezWolf(){
        setName("Lopez Wolf");
        setMaxHp(30);
        setHp(30);
        setAttackPower(6);
        setDefense(5);
        setSpeed(12);

        setExpReward(40);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
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