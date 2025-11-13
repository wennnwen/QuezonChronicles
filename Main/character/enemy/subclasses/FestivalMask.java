package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class FestivalMask extends Enemy {

    public FestivalMask() {
        setName("Festival Mask");
        setMaxHp(85);
        setHp(85);
        setAttackPower(5);
        setDefense(4);
        setSpeed(10);
        setSkillUsedTurn(2);

        setExpReward(50);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }
    @Override
    public void enemyMove(Player player) {
        System.out.println("The Festival Mask floats toward " + player.getName() + "!");
        System.out.println("It releases a dazzling light that confuses its target!");

        // Base damage
        int damage = getAttackPower();
        if (getSkillUsedTurn() <= 0) {
            double confuseChance = 0.4;
            if (Math.random() <= confuseChance){
                player.applyDebuff("confusion", 2);
                player.takeDamage(damage);
                setSkillUsedTurn(2);
            }else {
                player.takeDamage(damage);
            }
        } else {
            updateSkillUsedTurn(); // count down until the skill can be used
        }

        // Optional chance flavor (adds variety)
        double chance = Math.random();
        if (chance < 0.15) { // 15% chance for extra confusion feedback
            System.out.println(player.getName() + " hits themselves in confusion!");
            player.takeDamage(3);
        }
    }
}
