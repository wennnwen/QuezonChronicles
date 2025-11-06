package Main.item;

import Main.character.player.Player;

public class DriedFishSnack extends Item {

    public DriedFishSnack() {
        setName("Drie Fish Snack");
        setDescription("(Dried Fish Snack gives you additional damages for 2 turns.)");
    }

    @Override
    public void useItem(Player player) {
        int attackBoostAmount = 2;

        System.out.println(player.getName() + " ate the Dried Fish Snack!");
        System.out.println(player.getName() + " increased their speed by 2!");
        player.add(speedBoost);
    }
}