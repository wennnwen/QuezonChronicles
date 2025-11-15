package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class HeritageWraith extends Enemy{

    public HeritageWraith(){
        setName("Heritage Wraith");
        setMaxHp(90);
        setHp(90);
        setAttackPower(12);
        setDefense(5);
        setSpeed(9);

        setExpReward(75);

        // Possible loot
        setPossibleLoot(new Item[]{new Pinagong(), new Budin()});
    }

    @Override
    public void enemyMove(Player player) {
    String text = getName() + " lashes out with its shadowy claws at " + player.getName() + "!";
    centerHub.printRightTextWithTypeWriter(text);

    int baseDamage = getAttackPower();
    if (baseDamage < 0) baseDamage = 0;

    // Critical hit mechanic
    double critChance = 0.2;
    double critRoll = Math.random();
    if (critRoll < critChance) {
        baseDamage *= 2; // Critical hit doubles damage
        centerHub.printRightTextWithTypeWriter("Critical hit!");
    }

    //Defense debuff
    int defenseReduce = 1;
    int duration = 1;

        player.addDebuff(defenseReduce, duration);
        player.takeDamage(baseDamage);
    }
}