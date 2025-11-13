package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.printAlignmentHub.CenterHub;

public class LopezWolf extends Enemy{

    public LopezWolf(){
        setName("Lopez Wolf");
        setMaxHp(50);
        setHp(80);
        setAttackPower(12);
        setDefense(5);
        setSpeed(16);

        setExpReward(90);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }

    @Override
    public void enemyMove(Player player) {
    String text = getName() + " bites " + player.getName() + " with its strong jaws!";
    centerHub.printRightText(text);

    int baseDamage = getAttackPower();
    if (baseDamage < 0) baseDamage = 0;

    // Critical hit mechanic
    double critChance = 0.2;
    double critRoll = Math.random();
    if (critRoll < critChance) {
        baseDamage *= 2;
        centerHub.printRightText("Critical hit!");
    }

        player.takeDamage(baseDamage);
    }
}