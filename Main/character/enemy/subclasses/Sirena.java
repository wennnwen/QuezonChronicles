package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class Sirena extends Enemy {

    public Sirena() {
        setName("Gumacan Sirena");
        // Early game enemy - Town 1 (East)
        setMaxHp(55);
        setHp(55);
        setAttackPower(11);
        setDefense(4);
        setSpeed(8);
        setSkillUsedTurn(3);

        setExpReward(35);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = "The Gumaca Sirena sings a haunting melody towards " + player.getName() + "!";
        centerHub.printRightTextWithTypeWriter(text);

        int baseDamage = getAttackPower();
        if (baseDamage < 0) baseDamage = 0;

        double critChance = 0.15;
        if (Math.random() < critChance) {
            baseDamage *= 2;
            centerHub.printRightTextWithTypeWriter(textColor.RED + "Critical hit!" + textColor.RESET);
        }
        player.takeDamage(baseDamage);
    }
}
