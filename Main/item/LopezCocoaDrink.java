package Main.item;

import Main.character.player.Player;

public class LopezCocoaDrink extends Item {

    public LopezCocoaDrink() {
        setName("LopezCocoaDrink");
        setDescription("(+ 2 defense for 2 turns))");
    }

    @Override
    public void useItem(Player player) {
        int defenseboost = 5;
        int duration = 2;

        System.out.println(player.getName() + " drinks the Lopez Cocoa Drink!");
        System.out.println(player.getName() + " gained a temporary defense buff for 2 rounds!");
        player.addTemporaryDefenseBoost(5, 2);
    }
}