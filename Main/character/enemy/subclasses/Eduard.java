package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;
import Main.styles.textColor.TextColorHub;

public class Eduard extends Enemy{

    public Eduard() {
        setName("Aladdin of Mindoro, Eduard");
        setMaxHp(80);
        setHp(80);
        setAttackPower(4);
        setDefense(6);
        setSpeed(8);

        setExpReward(60);

        // Possible loot
        setPossibleLoot(new Item[]{new MountainHoney(), new Turon()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " uses Aladdin's Carpet Specter!";
        centerHub.printRightTextWithTypeWriter(text);
        
        String attackText = getName() + " dives on its flying carpet and crashes into " + player.getName() + " with force!";
        centerHub.printRightTextWithTypeWriter(attackText);

        int baseDamage = getAttackPower();// High attack power
        if (baseDamage < 0) baseDamage = 0;

        player.takeDamage(baseDamage);

        // 50% chance to stun player for 1 turn (only if not already stunned)
        double stunChance = 0.5;
        double stunRoll = Math.random();
        if (stunRoll < stunChance) {
            // Check if player already has stun debuff
            boolean alreadyStunned = false;
            String[] debuffs = player.getActiveDebuffs();
            for (String debuff : debuffs) {
                if (debuff != null && debuff.equalsIgnoreCase("stun")) {
                    alreadyStunned = true;
                    break;
                }
            }
            
            if (!alreadyStunned) {
                player.applyDebuff("stun", 2);
                centerHub.printRightTextWithTypeWriter(textColor.YELLOW + player.getName() + " is stunned by the impact!" + textColor.RESET);
            }
        }
    }
}