package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class HarborSentinel extends Enemy {

    public HarborSentinel() {
        setName("Harbor Sentinel");
        setMaxHp(260);
        setHp(260);
        setAttackPower(16); 
        setDefense(20);     
        setSpeed(2);        

        setExpReward(220);

        // Possible loot
        setPossibleLoot(new Item[]{new Chami(), new CocoJam()});
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " uses Anchor Smash on " + player.getName() + "!");

        int attackPower = getAttackPower();

        // Critical hit mechanic
        double critChance = 0.15;
        if (Math.random() < critChance) {
            attackPower *= 2;
            System.out.println("Critical hit!");
        }

        // Deal damage
        player.takeDamage(attackPower);
    }
}
