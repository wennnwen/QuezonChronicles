package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class QueenAmihan extends Enemy {

    public QueenAmihan() {
        setName("Queen Amihan");
        // Final boss - increased health and attack, unique wave heal ability remains
        setMaxHp(240);
        setHp(240);
        setAttackPower(28);
        setDefense(12);
        setSpeed(20);

        setExpReward(3000);

        // Possible loot
        setPossibleLoot(new Item[]{new SinigangHipon(), new TropicalBreezeJuice()});
    }

   @Override
    public void enemyMove(Player player) {
        String text = getName() + " conjures a towering wave, crashing it down on " + player.getName() + "!";
        centerHub.printRightTextWithTypeWriter(text);

        int attackPower = getAttackPower();
        
        // Deal damage after applying effects
        player.takeDamage(attackPower);
        heal(getAttackPower() / 2);
    }
}
