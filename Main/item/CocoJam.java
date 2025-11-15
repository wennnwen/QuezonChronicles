package Main.item;

import Main.character.player.Player;
import Main.styles.textColor.TextColorHub;

public class CocoJam extends Item {

    public CocoJam() {
        setName(textColor.ORANGE + "Coco Jam" + textColor.RESET);
        setDescription("(A sweet Lucena delicacy that restores Stamina. (For Stamina users only))");
    }

    @Override
    public void useItem(Player player) {

        int staminaBoost = 15;
        
        //check if the class uses stamina or mp

        System.out.println(player.getName() + " eats a Coco Jam!");
        System.out.println(player.getName() + "restores 15 amount of stamina!");

        if (!player.getUsesMp()) {
            player.addStamina(staminaBoost);
        }
        else {
        player.addMp(staminaBoost);
        }
    }
}
