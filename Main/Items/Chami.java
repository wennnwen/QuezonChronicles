public class Chami extends Items {

    // Constructor
    public Chami() {
        setName("Chami");
        setDescription("A sweet and savory noodle dish from Lucena that restores a good amount of HP.");
    }

    @Override
    public void useItem(Player player) {
    int healBoost = 40;

    System.out.println(player.getName() + " eats a Chami and restores a +40 HP!");
    player.heal(healBoost);
    }
}
