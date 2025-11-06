package Main.item;

import Main.character.player.Player;
import Main.character.Character;

public class AdobongPusit extends Item {

    public AdobongPusit() {
        setName("Adobong Pusit");
        setDescription("(A savory squid dish that restores +10hp and grants +3 Attack Power per turn for 2 turns.)");
    }

    @Override
    public void useItem(Player player) {
        int healthBoost = 10;
        int defenseBoost = 3;
        int duration = 2;

        System.out.println(player.getName() + " ate the Adobong Pusit!");
        System.out.println(player.getName() + " has temporarily increased their Defense by 3 for 2 turns!");
        player.heal(healthBoost);
        player.addTemporaryDefenseBoost(defenseBoost, duration);
    }
}
