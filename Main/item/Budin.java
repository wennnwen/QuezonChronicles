package Main.item;

import Main.character.player.Player;

public class Budin extends Item {

    public Budin() {
        setName("Budin");
        setDescription("(A sweet delicacy that boosts the player's attack power for 2 turns)");
    }

    @Override
    public void useItem(Player player) {
        int attackPowerBoost = 2;
        int duration = 2;

        System.out.println(player.getName() + " drinks the Pugon Coffee!");
        System.out.println(player.getName() + " has temporarily increased their Attack Power by 2");
        player.addTemporaryAttackBoost(attackPowerBoost, duration);
    }
}
