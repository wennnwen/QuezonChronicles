package Main.item;

import Main.character.player.Player;
import Main.styles.textColor.TextColorHub;

public class PugonCoffee extends Item {

    public PugonCoffee() {
        setName(textColor.YELLOW + "Pugon Coffee" + textColor.RESET);
        setDescription("(A strong brew that energizes the drinker, granting +1 Speed for the next turn.)");
    }

    @Override
    public void useItem(Player player) {
        int speedBoost = 1;

        System.out.println(player.getName() + " drinks the Pugon Coffee!");
        System.out.println(player.getName() + " has permanently increased their speed by 1!");
        player.addSpeed(speedBoost);
    }
}