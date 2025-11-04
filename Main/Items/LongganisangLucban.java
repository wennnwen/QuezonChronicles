public class LongganisangLucban extends Items {

    public LongganisangLucban() {
        setName("Longganisang Lucban");
        setDescription("(A flavorful Lucban sausage that increases Attack Power for 2 turns.)");
    }

    @Override
    public void useItem(Player player) {
    int attackBoost = 5;
    int duration = 2;

    System.out.println(player.getName() + " eats a Longganisang Lucban!");
    System.out.println(player.getName() + " gain a 5 Attack Power for 2 turns!");

    player.addTemporaryAttackBoost(attackBoost, duration);
    }
}