package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class SumanMimic extends Enemy {

    public SumanMimic() {
        setName("Suman Mimic");
        setMaxHp(80);
        setHp(80);
        setAttackPower(6);
        setDefense(1);
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

        int healAmount = 2;
        heal(healAmount);

        System.out.println(getName() + " absorbs energy from the hit and heals " + healAmount + " HP!");

    }
}