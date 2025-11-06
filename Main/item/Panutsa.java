package Main.item;

import Main.character.player.Player;

public class Panutsa extends Item{

    public Panutsa() {
        setName("Panutsa");
        setDescription("(A sweet treat that boosts your defense by +5 per turn for 2 turns.)");
    }

    @Override
    public void useItem(Player player) {
        int defenseBoost = 5;
        int duration = 2;

        System.out.println(player.getName() + " eats the Panutsa!");
        System.out.println(player.getName() + " has temporarily increased their defense by 5!");
        player.addTemporaryDefenseBoost(defenseBoost, duration);
    }
}
