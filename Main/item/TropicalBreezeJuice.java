package Main.item;

import Main.character.player.Player;
import Main.styles.textColor.TextColorHub;

public class TropicalBreezeJuice extends Item {

    public TropicalBreezeJuice() {
        setName(textColor.ORANGE + "Tropical Breeze Juice" + textColor.RESET);
        setDescription("(Begin a heroic journey where every decision alters your fate. Gives you stamina and speed.)");
    }

    @Override
    public void useItem(Player player) {
        int staminaBoost = 15;
        int speed = 3;
        
        //check if the class uses stamina or mp

        System.out.println(player.getName() + "ate the Mountain Honey!");
        if (!player.getUsesMp()) {
            player.addStamina(staminaBoost);
            System.out.println(player.getName() + "restored 15 amount of stamina!");
        }
        else {
        player.addMp(staminaBoost);
        System.out.println(player.getName() + "restored 15 amount of mp!");
        }
        player.addSpeed(speed);
    }
}
