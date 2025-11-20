package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class CoconutBrigade extends Enemy {

    public CoconutBrigade() {
        setName("Coconut Brigade");
        // Mid game enemy - Town 3
        setMaxHp(85);
        setHp(85);
        setAttackPower(16);
        setDefense(6);
        setSpeed(8);

        setExpReward(75);

        setPossibleLoot(new Item[]{new Lambanog(), new Pinagong()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " hurls a spinning coconut toward " + player.getName() + "!";
        centerHub.printRightTextWithTypeWriter(text);

        int baseDamage = getAttackPower();
        if (baseDamage < 0) baseDamage = 0;

        double critChance = 0.2;
        if(Math.random() < critChance){
            centerHub.printRightTextWithTypeWriter(textColor.RED + "Critical hit!" + textColor.RESET);
            baseDamage *= 2;
        }

        player.takeDamage(baseDamage);
    }
}
