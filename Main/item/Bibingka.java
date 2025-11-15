package Main.item;

import Main.character.player.Player;
import Main.styles.textColor.TextColorHub;

public class Bibingka extends Item {

    public Bibingka() {
        setName(textColor.GREEN + "Bibingka" + textColor.RESET);
        setDescription("(A warm rice cake from Candelaria that restores HP and removes all debuffs.)");
    }

    @Override
    public void useItem(Player player) {
        int healBoost = 25;

        System.out.println(player.getName() + " eats a Bibingka!");
        System.out.println(player.getName() + " restores a +25 HP and clear all debuffs!");
        player.heal(healBoost);
        player.removeDebuff();
    }
}    

