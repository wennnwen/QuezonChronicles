package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.printAlignmentHub.CenterHub;

public class QueenAmihan extends Enemy {

    public QueenAmihan() {
        setName("Queen Amihan");
        setMaxHp(100);
        setHp(100);
        setAttackPower(10); 
        setDefense(6);
        setSpeed(25);

        setExpReward(1500);

        // Possible loot
        setPossibleLoot(new Item[]{new SinigangHipon(), new TropicalBreezeJuice()});
    }

   @Override
    public void enemyMove(Player player) {
    String text = getName() + " conjures a towering wave, crashing it down on " + player.getName() + "!";
    centerHub.printRightText(text);

    int attackPower = getAttackPower();
    
    // Deal damage after applying effects
    player.takeDamage(attackPower);
    heal(getAttackPower() / 2);
    String healText = getName() + " heals for " + (getAttackPower() / 2) + " HP!";
    centerHub.printRightText(healText);
    }
}
