package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class FestivalMask extends Enemy {

    public FestivalMask() {
        setName("Festival Mask");
        setMaxHp(85);
        setHp(85);
        setAttackPower(10);
        setDefense(4);
        setSpeed(10);

        setExpReward(50);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }
    @Override
    public void enemyMove(Player player) {
        System.out.println("\nThe Festival Mask floats toward " + player.getName() + "!");
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
