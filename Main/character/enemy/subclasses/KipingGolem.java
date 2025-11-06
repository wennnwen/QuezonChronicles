package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;

public class KipingGolem extends Enemy {

    public KipingGolem() {
        setName("Kipping Golem");
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
    private void enemyMove(Player player) {
        System.out.println("\n💥 The Kiping Golem slams the ground, sending Kiping shards flying!");
        
        int damage = getAttackPower();
        player.takeDamage(damage);
    }
}