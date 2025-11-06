package Main.Character.Enemy.Subclasses;

import Main.Items.*;

public class OldTrainSpirit extends Enemy {

    public OldTrainSpirit() {
        setName("Old Train Spirit");
        setMaxHp(120);
        setHp(120);
        setAttackPower(16);
        setDefense(10);
        setSpeed(5);

        // Experience reward
        expReward = 80;

        // Possible loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new Tinuto();
        possibleLoot[1] = new PugonCoffee();
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println("\n🚂 The Old Train Spirit charges with unstoppable force!");
        System.out.println("💨 It uses its signature move: 'Iron Charge'!");

        // Calculate base damage
        int damage = getAttackPower() + 5; // Extra impact for the charge
        player.takeDamage(damage);

        // 25% chance to stun the player for 1 turn
        double chance = Math.random();
        if (chance < 0.25) {
            player.applyDebuff("stun", 1);
        }

        // Cool flavor feedback
        System.out.println(getName() + " rattles the ground as it passes by!");
    }
}