package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class KipingGolem extends Enemy {

    public KipingGolem() {
        setName("Kiping Golem");
        // Early game enemy - Town 1 (East)
        setMaxHp(50);
        setHp(50);
        setAttackPower(10);
        setDefense(3);
        setSpeed(4);

        setExpReward(30);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }
    
    @Override
    public void enemyMove(Player player) {
        centerHub.printRightTextWithTypeWriter("The Kiping Golem slams the ground, sending Kiping shards flying!");
        
        int damage = getAttackPower();
        player.takeDamage(damage);
    }
}