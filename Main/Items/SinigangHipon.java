public class SinigangHipon extends Items {

    public SinigangHipon() {
        setName("Sinigang na Hipon");
        setDescription("A tangy shrimp soup that restores +20 HP and removes all negative effects from the player.");
    }

    @Override
    public void useItem(Player player) {
        int healBoost = 20;
        //DEBUFF REMOVAL

        System.out.println(player.getName() + " has drunk the Lambanog Leche Flan!");

        player.heal(healBoost);
        //DEBUFF REMOVAL

    }
}
