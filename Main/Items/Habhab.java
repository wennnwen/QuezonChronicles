public class Habhab extends Items {

    public Habhab() {
        setName("Habhab");
        setDescription("A famous Lucban noodle dish that restores HP and Stamina/MP.");
    }

    @Override
    public void useItem(Player player) {
    int healBoost = 25;
    int staminaBoost, mpBoost;
    staminaBoost = mpBoost = 10;


    //getclass for mp/stamina
    System.out.println(player.getName() + " eats a Habhab!");
    //System.out.println(player.getName() + " restored 25 HP and 10 Stamina!");
    player.heal(healBoost);
    player.addStamina(staminaBoost);
    player.addMp(mpBoost);
    }
}

