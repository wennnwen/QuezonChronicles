package Main.item;

import Main.character.player.Player;
import Main.styles.textColor.TextColorHub;

public class LongganisangLucban extends Item {

    public LongganisangLucban() {
        setName(textColor.RED + "Longganisang Lucban" + textColor.RESET);
        setDescription("(A flavorful Lucban sausage that increases Attack Power for 2 turns.)");
    }

    @Override
    public void useItem(Player player) {
    int attackBoost = 5;
    int duration = 2;

    System.out.println(player.getName() + " eats a Longganisang Lucban!");
    System.out.println(player.getName() + " gain a 5 Attack Power for 2 turns!");

    player.addTemporaryAttackBoost(attackBoost, duration);
    }
}