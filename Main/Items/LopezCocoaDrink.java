package Main.Items;

import Main.Character.Player.*;

public class LopezCocoaDrink extends Items {

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