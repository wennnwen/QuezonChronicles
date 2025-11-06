package Main.character.enemy.subclasses;

import Main.item.*;

public class SweetVendor extends Enemy {

    public SweetVendor() {
        setName("Sweet Vendor Spirit");
        setMaxHp(80);
        setHp(80);
        setAttackPower(18);
        setDefense(8);
        setSpeed(6);

        // Experience reward
        expReward = 45;

        // Possible loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new Bibingka();
        possibleLoot[1] = new Panutsa();
    }
    @Override
    public void enemyMove(Player player) {
        System.out.println("\n👻 The Sweet Vendor Spirit attacks!");
        System.out.println("The spirit hurls enchanted sweets that explode on impact!");

        // Basic single move
        int damage = getAttackPower();
        
        double chance = Math.random();  // gives a random number between 0.0 and 1.0
        if (chance < 0.20) { // 20% chance
            damage *= 2;
            System.out.println("Critical Hit! The candy explodes with extra force!");
        }


        player.takeDamage(damage);
        
    }
}
