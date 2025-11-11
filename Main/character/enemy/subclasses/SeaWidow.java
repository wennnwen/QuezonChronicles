package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class SeaWidow extends Enemy {

    public SeaWidow() {
        setName("Sea Widow");
        setMaxHp(110);
        setHp(110);
        setAttackPower(12); 
        setDefense(3);
        setSpeed(9);

        setExpReward(110);

        // Possible loot
        setPossibleLoot(new Item[]{new AdobongPusit(), new DriedFishSnack()});
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " casts the Gleaming Deadly Hook at " + player.getName() + "!");

        int attackPower = getAttackPower();

    // weakens the player
        double weakenChance = 0.2; // 20% chance
        if (Math.random() < weakenChance) {
        attackPower -= 5; // or any value you want to decrease
        System.out.println("You feel weaker! Attack power reduced.");
}


        // Deal damage
        player.takeDamage(attackPower);
    }
}
