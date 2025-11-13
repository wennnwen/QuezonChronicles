package Main.item;

import Main.character.player.Player;

public class Lambanog extends Item {

    public Lambanog() {
        setName("Lambanog");
        setDescription("(A potent coconut spirit prized in local taverns, often used in celebrations or risky gambles throughout the realm)");
    }

    @Override
    public void useItem(Player player) {
        int staminaBoost = 15;
        
        //check if the class uses stamina or mp

        System.out.println(player.getName() + "drinks the Lambanog!");
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
