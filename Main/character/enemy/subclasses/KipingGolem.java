package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class KipingGolem extends Enemy {

    public KipingGolem() {
        setName("Kipping Golem");
        setMaxHp(190);
        setHp(190);
        setAttackPower(12);
        setDefense(12);
        setSpeed(5);

        setExpReward(80);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }
    
    @Override
    public void enemyMove(Player player) {
        System.out.println("\nThe Kiping Golem slams the ground, sending Kiping shards flying!");
        
        int damage = getAttackPower();
        player.takeDamage(damage);
    }
}