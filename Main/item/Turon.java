package Main.item;

import Main.character.player.Player;

public class Turon extends Item {

    public Turon() {
        setName("Turon");
        setDescription("(Local delicacy. Gives you additional damage.)");
    }

    @Override
    public void useItem(Player player) {
        int attackBoostAmount = 15;
        int duration = 5;
        
        //check if the class uses stamina or mp

        System.out.println(player.getName() + "ate the turon!");
        System.out.println(player.getName() + "gains a temporary attack damage boost.");

        player.addTemporaryAttackBoost(15, 5);
    }
}