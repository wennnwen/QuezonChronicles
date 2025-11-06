package Main.character.enemy.subclasses;

import Main.item.*;

public class SeaWidow extends Enemy {

    public SeaWidow() {
        setName("Sea Widow");
        setMaxHp(60);
        setHp(60);
        setAttackPower(12); 
        setDefense(8);
        setSpeed(10);

        expReward = 60;

        // Possible Loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new AdobongPusit();
        possibleLoot[1] = new DriedFishSnack();
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
