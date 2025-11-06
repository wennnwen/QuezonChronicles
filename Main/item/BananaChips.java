package Main.item;

import Main.character.player.Player;

public class BananaChips extends Item {

    public BananaChips() {
        setName("Banana Chips");
        setDescription("(Crispy banana chips. Quick energy boost grants +2 Speed for one turn.)");
    }

    @Override
    public void useItem(Player player) {

        System.out.println(player.getName() + " ate the Banana Chips!");
        System.out.println(player.getName() + " increased their speed by 2!");
        player.addSpeed(2);
    }
}