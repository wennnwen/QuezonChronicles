package Main.Items;

import Main.Character.Player.*;

public class MountainHoney extends Items {

    public MountainHoney() {
        setName("Mountain Honey");
        setDescription("(Delicous Mountain Honey that gives you stamina)");
    }

    @Override
    public void useItem(Player player) {
        int staminaBoost = 15;
        
        //check if the class uses stamina or mp

        System.out.println(player.getName() + "ate the Mountain Honey!");
        System.out.println(player.getName() + "restores 15 amount of stamina!");

        player.addStamina(staminaBoost);
    }
}
