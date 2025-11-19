package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class SweetVendor extends Enemy {

    public SweetVendor() {
        setName("Sweet Vendor Spirit");
        // Mid-late game enemy - Town 4
        setMaxHp(100);
        setHp(100);
        setAttackPower(21);
        setDefense(8);
        setSpeed(9);

        // Experience reward
        setExpReward(90);

        // Possible loot
        setPossibleLoot(new Item[]{new Bibingka(), new Panutsa()});
    }
    
    @Override
    public void enemyMove(Player player) {
        centerHub.printRightTextWithTypeWriter("The Sweet Vendor Spirit attacks!");
        centerHub.printRightTextWithTypeWriter("The spirit hurls enchanted sweets that explode on impact!");

        // Basic single move
        int damage = getAttackPower();
        
        double chance = Math.random(); 
        if (chance < 0.20) {
            damage *= 2;
            centerHub.printRightTextWithTypeWriter(textColor.RED + "Critical Hit! The candy explodes with extra force!" + textColor.RESET);
        }


        player.takeDamage(damage);
        
    }
}
