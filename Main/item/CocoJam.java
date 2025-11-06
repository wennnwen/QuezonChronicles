package Main.Items;

import Main.Character.Player.*;

public class CocoJam extends Items {

    public CocoJam() {
        setName("Coco Jam");
        setDescription("(A sweet Lucena delicacy that restores Stamina. (For Stamina users only))");
    }

    @Override
    public void useItem(Player player) {
        int staminaBoost = 15;
        
        //check if the class uses stamina or mp

        System.out.println(player.getName() + " eats a Coco Jam!");
        System.out.println(player.getName() + "restores 15 amount of stamina!");

        player.addStamina(staminaBoost);
    }
}
