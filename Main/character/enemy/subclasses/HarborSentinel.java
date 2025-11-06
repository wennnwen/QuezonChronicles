package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class HarborSentinel extends Enemy {

    public HarborSentinel() {
        setName("Harbor Sentinel");
        setMaxHp(50);
        setHp(50);
        setAttackPower(8); 
        setDefense(12);     
        setSpeed(6);        

        // Experience reward
        expReward = 120;

        // Possible Loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new Chami();
        possibleLoot[1] = new CocoJam();

    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " uses Anchor Smash on " + player.getName() + "!");

        int attackPower = getAttackPower();

        // Critical hit mechanic
        double critChance = 0.15;
        if (Math.random() < critChance) {
            attackPower *= 2;
            System.out.println("Critical hit!");
        }

        // Deal damage
        player.takeDamage(attackPower);
    }
}
