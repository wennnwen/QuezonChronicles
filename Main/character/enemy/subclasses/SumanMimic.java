package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class SumanMimic extends Enemy {

    public SumanMimic() {
        setName("Suman Mimic");
        setMaxHp(100);
        setHp(100);
        setAttackPower(6);
        setDefense(7);
        setSpeed(7);

        setExpReward(60);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println("\n🍡 The Suman Mimic wriggles its rice wrap and attacks!");
        int damage = getAttackPower();

        // Attack the player
        player.takeDamage(damage);

        // After attacking, it heals itself slightly
        int healAmount = 8; // flat heal, or you can scale with attackPower (e.g. getAttackPower()/2)
        setHp(getHp() + healAmount);

        System.out.println(getName() + " absorbs energy from the hit and heals " + healAmount + " HP!");

    }
}