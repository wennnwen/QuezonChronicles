package Main.worldBuilder;

import java.util.Scanner;
import Main.character.enemy.Enemy;
import Main.character.player.Player;
import Main.game.BattleSystem;

public class Town {
    private String name;
    private String description;
    private Enemy[] enemies;
    private Enemy boss;
    private Town nextTown;

    public Town(String name, String description, Enemy[] enemies, Enemy boss) {
        this.name = name;
        this.description = description;
        this.enemies = enemies;
        this.boss = boss;
    }

    public void setNextTown(Town nextTown) {
        this.nextTown = nextTown;
    }

    public void enterTown(Player player) {
        System.out.println("\n=== " + name.toUpperCase() + " ===");
        System.out.println(description);

        int enemiesDefeated = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            if (player.getHp() == 0) {
                break;
            }
            System.out.println("\nOptions:");
            System.out.println("1. Explore / Battle");
            System.out.println("2. Move to next town");
            System.out.println("3. Check player stats");
            System.out.println("4. Exit to main menu");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (boss == null && enemiesDefeated < 2) {
                        Enemy randomEnemy = enemies[(int)(Math.random() * enemies.length)];
                        System.out.println("A wild " + randomEnemy.getName() + " appeared!");
                        new BattleSystem().BattleStart(player, randomEnemy);
                        enemiesDefeated++;
                    } else if (boss != null && enemiesDefeated < 2) {
                        Enemy randomEnemy = enemies[(int)(Math.random() * enemies.length)];
                        System.out.println("A wild " + randomEnemy.getName() + " appeared!");
                        new BattleSystem().BattleStart(player, randomEnemy);
                        enemiesDefeated++;
                    } else if (boss != null && enemiesDefeated == 2) {
                        Enemy enemy = boss;
                        System.out.println("\nThe boss of " + name + " appears: " + boss.getName() + "!");
                        new BattleSystem().BattleStart(player, enemy);
                        enemiesDefeated++;
                        System.out.println("You’ve cleared " + name + "!");
                    } else {
                        System.out.println("You’ve already cleared all enemies here!");
                    }
                    break;

                case 2:
                    if ((boss == null && enemiesDefeated >= 2) || (boss != null && enemiesDefeated >= 3)) {
                        if (nextTown != null) {
                            System.out.println("Travelling to " + nextTown.name + "...");
                            nextTown.enterTown(player);
                            return;
                        } else {
                            System.out.println("You’ve reached the end of your journey!");
                            return;
                        }
                    } else {
                        System.out.println("You must defeat all enemies before moving on!");
                    }
                    break;

                case 3:
                    player.showStats();
                    break;

                case 4:
                    System.out.println("Returning to main menu...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
