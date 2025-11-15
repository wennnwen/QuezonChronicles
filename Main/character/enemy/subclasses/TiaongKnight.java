package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class TiaongKnight extends Enemy {

    public TiaongKnight() {
        setName("Tiaong Knight");
        setMaxHp(150);
        setHp(150);
        setAttackPower(5); 
        setDefense(2);
        setSpeed(9);

        setExpReward(60);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " heavily swings their sword at " + player.getName() + "!";
        centerHub.printRightTextWithTypeWriter(text);

        int attackPower = getAttackPower();

        //Critical Damage
        double critChance = 0.5; //50% chance
        if (Math.random() < critChance) {
            attackPower *= 2;
            centerHub.printRightTextWithTypeWriter(textColor.RED + "Critical hit!" + textColor.RESET);
        }
        // Deal damage
        player.takeDamage(attackPower);
    }
}
