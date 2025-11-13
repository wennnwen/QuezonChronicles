package Main.item;

import Main.character.player.Player;

public class DriedFishSnack extends Item {

    public DriedFishSnack() {
        setName("Dried Fish Snack");
        setDescription("(Dried Fish Snack gives you additional damage for 2 turns.)");
    }

    @Override
    public void useItem(Player player) {
        int attackBoostAmount = 2;

        System.out.println(player.getName() + " ate the Dried Fish Snack!");
        player.addTemporaryAttackBoost(attackBoostAmount, 2);
    }
}