package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class HoneyGuardian extends Enemy {

    public HoneyGuardian() {
        setName("Honey Guardian");
        setMaxHp(60);
        setHp(60);
        setAttackPower(12); 
        setDefense(8);
        setSpeed(10);

        setExpReward(60);

        // Possible loot
        setPossibleLoot(new Item[]{new LambanogLecheFlan(), new MountainHoney()});
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " summons a horde of angry bees at " + player.getName() + "!");

        int attackPower = getAttackPower();

        // Critical hit mechanic
        double critChance = 0.2; // 20% chance
        if (Math.random() < critChance) {
            attackPower *= 2;
            System.out.println("Critical hit!");
        }

        //poison tite
        double poisonChance = 0.25; // 25% chance
        if (Math.random() < poisonChance) {
        player.addDebuff("Poison", 2);
        System.out.println(player.getName() + " is poisoned for 2 turns!");
}

        // Deal damage
        player.takeDamage(attackPower);
        
    }
}
