package Main.item;

import Main.character.player.Player;

public class MountainHoney extends Item{

    public MountainHoney() {
        setName("Mountain Honey");
        setDescription("(Delicous Mountain Honey that gives you stamina)");
    }

    @Override
    public void useItem(Player player) {
        int staminaBoost = 15;
        
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
    }
}
