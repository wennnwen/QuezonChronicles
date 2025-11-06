package Main.item;

import Main.character.player.Player;

public class Pinagong extends Item {

    public Pinagong() {
        setName("Pinagong");
        setDescription("(A soft bread from Sariaya that restores a small amount of HP.)");
    }

    @Override
    public void useItem(Player player) {
        int healBoost = 30;
        
        System.out.println(player.getName() + " eats a Pinagong and restores +30 HP!");
        player.heal(healBoost);
    }
}