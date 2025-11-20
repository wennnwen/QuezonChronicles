package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class SumanMimic extends Enemy {

    public SumanMimic() {
        setName("Suman Mimic");
        // Early-mid game enemy - Town 2 (East)
        setMaxHp(70);
        setHp(70);
        setAttackPower(14);
        setDefense(5);
        setSpeed(8);

        setExpReward(40);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }

    @Override
    public void enemyMove(Player player) {
        centerHub.printRightTextWithTypeWriter("The Suman Mimic wriggles its rice wrap and attacks!");
        int damage = getAttackPower();

        // Attack the player
        player.takeDamage(damage);

        int healAmount = 2;
        heal(healAmount);

        String text = getName() + " absorbs energy from the hit and heals " + healAmount + " HP!";
        centerHub.printRightTextWithTypeWriter(text);
    }
}