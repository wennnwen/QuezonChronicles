package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class RealSpecter extends Enemy {

    public RealSpecter() {
        setName("Real Specter");
        // Late game enemy - Town 5 (East)
        setMaxHp(125);
        setHp(125);
        setAttackPower(26); 
        setDefense(11);
        setSpeed(12);

        setExpReward(120);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " unleashes a blood-curdling shriek that chills " + player.getName() + " to the bone!";
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
