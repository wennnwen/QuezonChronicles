package Main.item;

import Main.character.player.Player;

public class LambanogLecheFlan extends Item {

    public LambanogLecheFlan() {
        setName("Lambanog Leche Flan");
        setDescription("(A creamy dessert infused with local spirit that restores +15 HP but reduces Defense by 2 due to dizziness for 2 turns.)");
    }

    @Override
    public void useItem(Player player) {
        int healBoost = 15;
        int duration = 2;

        System.out.println(player.getName() + " has drunk the Lambanog Leche Flan!");

        player.heal(healBoost);
        player.applyDebuff("defense down", duration);

    }
}
