package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class PugonPhantom extends Enemy {

    public PugonPhantom() {
        setName("Pugon Phantom");
        setMaxHp(80);
        setHp(80);
        setAttackPower(5);
        setDefense(3);
        setSpeed(11);
        
        setExpReward(600);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }
    @Override
    public void enemyMove(Player player) {
        centerHub.printRightTextWithTypeWriter("The Pugon Phantom attacks!");
        centerHub.printRightTextWithTypeWriter("Pugon Phantom swings a blazing spectral arm, realeasing fiery embers!");

        // Basic single move
        int damage = getAttackPower();
        player.takeDamage(damage);

        // Inflict burn debuff
        player.applyDebuff("burn", 3);

        // Drain stamina (only if the player uses stamina)
        if (player.getStamina() > 0) {
            int drain = 5;
            int newStamina = player.getStamina() - drain;
            if (newStamina < 0) newStamina = 0;
            player.setStamina(newStamina);
            String text = player.getName() + "'s stamina is drained by " + drain + "!";
            centerHub.printRightTextWithTypeWriter(text);
        }
        
        
    }
}