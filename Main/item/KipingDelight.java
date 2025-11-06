package Main.item;

import Main.character.player.Player;

public class KipingDelight extends Item {

    public KipingDelight() {
        setName("Kiping Delight");
        setDescription("(A flat, crunchy, and sweet bread.) ");
    }

    @Override
    public void useItem(Player player) {
        int healthBoost = 25;
        int defenseBoost = 4;
        int duration = 2;

        System.out.println(player.getName() + " ate the Kiping Delight!");
        System.out.println(player.getName() + " has temporarily increased their Defense by 4! Healed by 25!");
        player.heal(healthBoost);
        player.addTemporaryDefenseBoost(defenseBoost, duration);
    }
}
