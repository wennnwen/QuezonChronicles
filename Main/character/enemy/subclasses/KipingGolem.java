package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class KipingGolem extends Enemy {

    public KipingGolem() {
        setName("Kipping Golem");
        setMaxHp(120);
        setHp(120);
        setAttackPower(16);
        setDefense(10);
        setSpeed(5);

        setExpReward(80);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }
    
    @Override
    private void enemyMove(Player player) {
        System.out.println("\n💥 The Kiping Golem slams the ground, sending Kiping shards flying!");
        
        int damage = getAttackPower();
        player.takeDamage(damage);
    }
}