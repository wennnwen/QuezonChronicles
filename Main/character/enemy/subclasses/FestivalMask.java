package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class FestivalMask extends Enemy {

    public FestivalMask() {
        setName("Festival Mask");
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
         System.out.println("\n🎭 The Festival Mask floats toward " + player.getName() + "!");
        System.out.println("It releases a dazzling light that confuses its target!");

        // Base damage
        int damage = getAttackPower();
        player.takeDamage(damage);

        // Apply confusion debuff (lasts 2 turns)
        player.applyDebuff("confusion", 2);

        // Optional chance flavor (adds variety)
        double chance = Math.random();
        if (chance < 0.15) { // 15% chance for extra confusion feedback
            System.out.println(player.getName() + " hits themselves in confusion!");
            player.takeDamage(5);
        }
        
        
    }
}
