package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.printAlignmentHub.CenterHub;

public class LucenaPirate extends Enemy{

    public LucenaPirate(){
        setName("Lucena Pirate");
        setMaxHp(80);
        setHp(80);
        setAttackPower(10);
        setDefense(5);
        setSpeed(12);

        setExpReward(180);

        // Possible loot
        setPossibleLoot(new Item[]{new Chami(), new CocoJam()});
    }

    @Override
    public void enemyMove(Player player) {
    String text = getName() + " lunges towards " + player.getName() + " fiercely!";
    centerHub.printRightText(text);

    int baseDamage = getAttackPower();
    if (baseDamage < 0) baseDamage = 0;

    // Critical hit mechanic
    double critChance = 0.1;
    if (Math.random() < critChance) {
        baseDamage *= 2;
        centerHub.printRightText("Critical hit!");
    }

        player.takeDamage(baseDamage);
    }
}