package Main.item;

import Main.character.player.Player;
import Main.styles.textColor.TextColorHub;

public class SinigangHipon extends Item {

    public SinigangHipon() {
        setName(textColor.GREEN + "Sinigang na Hipon" + textColor.RESET);
        setDescription("(A tangy shrimp soup that restores +20 HP and removes all negative effects from the player.)");
    }

    @Override
    public void useItem(Player player) {
        int healBoost = 20;
        //DEBUFF REMOVAL

        System.out.println(player.getName() + " has eaten the Sinigang na Hipon!");

        player.heal(healBoost);
        player.removeDebuff();

    }
}
