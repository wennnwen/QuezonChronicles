public class LambanogLecheFlan extends Items {

    public LambanogLecheFlan() {
        setName("Lambanog Leche Flan");
        setDescription("A creamy dessert infused with local spirit that restores +15 HP but reduces Defense by 2 due to dizziness for 2 turns.");
    }

    @Override
    public void useItem(Player player) {
        int healBoost = 15;
        int defenseReduce = 2;
        int duration = 2;

        System.out.println(player.getName() + " has drunk the Lambanog Leche Flan!");

        player.heal(healBoost);
        player.addDefenseDebuff(defenseReduce, duration);

    }
}
