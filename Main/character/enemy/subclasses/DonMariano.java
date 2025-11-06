package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class DonMariano extends Enemy {

    public DonMariano() {
        setName("Don Mariano the Collector");
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
        
        System.out.println("\n Don Mariano the Collector uses 'Greed's Flame'!");
        System.out.println("A wave of cursed fire engulfs " + player.getName() + " — their life force is drained!");

        // Base damage
        int damage = getAttackPower() + 5;
        
        // Apply damage to player
        int playerHpBefore = player.getHp();
        player.takeDamage(damage);

        // Calculate actual damage dealt
        int damageDealt = playerHpBefore - player.getHp();

        // Absorb (heal) a portion of the damage dealt
        int healAmount = (int) (damageDealt * 0.5); // absorbs 50% of the damage
        setHp(getHp() + healAmount);

        // Burn effect on player (optional for extra challenge)
        player.applyDebuff("burn", 3);

        // Battle feedback
        System.out.println("🔥 Don Mariano absorbs " + healAmount + " HP from " + player.getName() + "!");
        System.out.println("Current HP: " + getHp() + "/" + getMaxHp());

    }
}