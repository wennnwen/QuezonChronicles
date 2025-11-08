package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class PugonPhantom extends Enemy {

    public PugonPhantom() {
        setName("Pugon Phantom");
        setMaxHp(420);
        setHp(420);
        setAttackPower(22);
        setDefense(14);
        setSpeed(11);
        
        setExpReward(600);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }
    @Override
    public void enemyMove(Player player) {
        System.out.println("\n👻 The Sweet Vendor Spirit attacks!");
        System.out.println("The spirit hurls enchanted sweets that explode on impact!");

        // Basic single move
        int damage = getAttackPower();
        player.takeDamage(damage);

        // Inflict burn debuff
        player.applyDebuff("burn", 3);

        // Drain stamina (only if the player uses stamina)
        if (player.getStamina() > 0) {
            int drain = 5;
            int newStamina = player.getStamina() - drain;
            if (newStamina < 0) newStamina = 0;
            player.setStamina(newStamina);
            System.out.println(player.getName() + "'s stamina is drained by " + drain + "!");
        }
        
        
    }
}