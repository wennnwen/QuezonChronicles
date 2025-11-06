package Main.Character.Enemy.Subclasses;

import Main.Items.*;

public class QueenAmihan extends Enemy {

    public QueenAmihan() {
        setName("Queen Amihan");
        setMaxHp(60);
        setHp(60);
        setAttackPower(12); 
        setDefense(8);
        setSpeed(10);

        expReward = 60;

        // Possible Loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new SinigangHipon();
        possibleLoot[1] = new TropicalBreezeJuice();
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
