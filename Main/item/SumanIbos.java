package Main.Items;

import Main.Character.Player.*;

public class SumanIbos extends Items {

    public SumanIbos() {
        setName("Suman sa Ibos");
        setDescription("(A sticky rice treat that heals for 30 health.)");
    }

    @Override
    public void useItem(Player player) {
        int healBoost = 30;

        System.out.println(player.getName() + " ate the Suman sa Ibos!");
        System.out.println(player.getName() + " has healed by +30hp.");
        player.heal(healBoost);
    }
}
