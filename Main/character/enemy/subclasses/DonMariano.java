package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class DonMariano extends Enemy {

    public DonMariano() {
        setName("Don Mariano");
        setMaxHp(80);
        setHp(80);
        setAttackPower(28);
        setDefense(12);
        setSpeed(6);
        setSkillUsedTurn(2);

        setExpReward(1200);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }
    @Override
    public void enemyMove(Player player) {
        
        System.out.println("\n" + getName() + " uses 'Greed's Flame'!");

        // Base damage
        int damage = getAttackPower();
        player.takeDamage(damage);        

        //Roll chances for effect
        double attackRoll = 0.5;
        double healChance = 0.15;

        if (Math.random() <= attackRoll) {
            if (getSkillUsedTurn() <= 0) {
                player.applyDebuff("burn", 2);
                setSkillUsedTurn(2);
            }
            else {
                updateSkillUsedTurn();
            }
        }

        if (Math.random() <= healChance) {
            int healAmount = (int) (player.getAttackPower() * 0.5);
            heal(healAmount);
            System.out.println("Don Mariano absorbs " + healAmount + " damage from " + player.getName() + "!");
        }

        if (getSkillUsedTurn() > 0) {
            updateSkillUsedTurn();
        }
    }
}