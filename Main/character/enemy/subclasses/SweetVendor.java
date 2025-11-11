package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class SweetVendor extends Enemy {

    public SweetVendor() {
        setName("Sweet Vendor Spirit");
        setMaxHp(110);
        setHp(110);
        setAttackPower(8);
        setDefense(5);
        setSpeed(6);

        // Experience reward
        setExpReward(120);

        // Possible loot
        setPossibleLoot(new Item[]{new Bibingka(), new Panutsa()});
    }
    
    @Override
    public void enemyMove(Player player) {
        System.out.println("\nThe Sweet Vendor Spirit attacks!");
        System.out.println("The spirit hurls enchanted sweets that explode on impact!");

        // Basic single move
        int damage = getAttackPower();
        
        double chance = Math.random(); 
        if (chance < 0.20) {
            damage *= 2;
            System.out.println("Critical Hit! The candy explodes with extra force!");
        }


        player.takeDamage(damage);
        
    }
}
