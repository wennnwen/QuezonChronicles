package Main.item;

import Main.character.player.Player;

public class Habhab extends Item {

    public Habhab() {
        setName("Habhab");
        setDescription("(A famous Lucban noodle dish that restores HP and Stamina/MP.)");
    }

    @Override
    public void useItem(Player player) {
    int healBoost = 25;
    int staminaBoost = 10;

    System.out.println(player.getName() + " eats a Habhab!");
    System.out.println(player.getName() + " restored 25 HP and 10 Stamina!");
    player.heal(healBoost);
    if (!player.getUsesMp()) {
            player.addStamina(staminaBoost);
        }
        else {
        player.addMp(staminaBoost);
        }
    }
}

