public class Pinagong extends Items {

    public Pinagong() {
        setName("Pinagong");
        setDescription("A soft bread from Sariaya that restores +30 of HP.");
    }

    @Override
    public void useItem(Player player) {
        int healAmount = 30;
        int newHp = player.getHp() + healAmount;

        //prevent overheal
        if (newHp > player.getMaxHp()) {
            newHp = player.getMaxHp();
        } 

        player.setHp(newHp);
        System.out.println(player.getName() + " eats a Pinagong and restores " + healAmount + " HP!");
        System.out.println("Current HP: " + player.getHp() + "/" + player.getMaxHp());
    }
}
