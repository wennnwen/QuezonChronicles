package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class QueenAmihan extends Enemy {

    public QueenAmihan() {
        setName("Queen Amihan");
        setMaxHp(60);
        setHp(60);
        setAttackPower(12); 
        setDefense(8);
        setSpeed(10);

        setExpReward(60);

        // Possible loot
        setPossibleLoot(new Item[]{new SinigangHipon(), new TropicalBreezeJuice()});
    }

   @Override
    public void enemyMove(Player player) {
    System.out.println(getName() + " conjures a towering wave, crashing it down on " + player.getName() + "!");

    int attackPower = getAttackPower();
    
    // Deal damage after applying effects
    player.takeDamage(attackPower);
    heal(getHp() + 1);

}


}
