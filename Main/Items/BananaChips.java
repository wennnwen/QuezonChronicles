package Main.Items;

public class BananaChips extends Items {

    public BananaChips() {
        setName("Banana Chips");
        setDescription("(Crispy banana chips. Quick energy boost grants +2 Speed for one turn.)");
    }

    @Override
    public void useItem(Player player) {
        int speedBoost = 2;

        System.out.println(player.getName() + " ate the Banana Chips!");
        System.out.println(player.getName() + " increased their speed by 2!");
        player.addSpeed(speedBoost);
    }
}