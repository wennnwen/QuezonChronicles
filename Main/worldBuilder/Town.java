package Main.worldBuilder;

import java.util.Scanner;
import Main.character.enemy.Enemy;
import Main.character.Character;
import Main.character.player.Player;
import Main.game.BattleSystem;
import Main.item.*;
import Main.printAlignmentHub.CenterHub;

public class Town {
    private String name;
    private String description;
    private Enemy[] enemies;
    private Enemy boss;
    private Town nextTown;
    private CenterHub centerHub = new CenterHub();

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
        System.out.println("\n=======================================================================" + name.toUpperCase() + "=======================================================================");
        centerHub.printCenteredText(description);
        System.out.println("=====================================================================================================================================================");

        int enemiesDefeated = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            if (player.getHp() == 0) {
                System.out.println("You have fallen in battle!");
                System.out.println("Resetting your progress and returning to the main menu...");
                // Reset player progress on death
                player.resetProgress();
                break;
            }
            int totalCount = (enemies != null ? enemies.length : 0) + (boss != null ? 1 : 0);
            int remaining = Math.max(0, totalCount - enemiesDefeated);
            System.out.println("\nEnemies left: " + remaining);
            System.out.println("\nOptions:");
            System.out.println("1. Explore / Battle");
            System.out.println("2. Move to next town");
            System.out.println("3. Check player stats");
            System.out.println("4. Inventory");
            System.out.println("5. Exit to main menu");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (enemies != null && enemiesDefeated < enemies.length) {
                        Enemy enemy = enemies[enemiesDefeated];
                        System.out.println("A wild " + enemy.getName() + " appeared!");
                        new BattleSystem().BattleStart(player, enemy);
                        enemiesDefeated++;
                    } else if (boss != null && enemiesDefeated == (enemies != null ? enemies.length : 0)) {
                        System.out.println("\nYou've reached the boss battle!");
                        System.out.println("\nThe boss of " + name + " appears: " + boss.getName() + "!");
                        new BattleSystem().BattleStart(player, boss);
                        enemiesDefeated++;
                        System.out.println("You’ve cleared " + name + "!");
                    } else {
                        System.out.println("You’ve already cleared all enemies here!");
                    }
                    break;

                case 2:
                    if ((boss == null && enemiesDefeated >= 3) || (boss != null && enemiesDefeated >= 3)) {
                        if (nextTown != null) {
                            System.out.println("Travelling to " + nextTown.name + "...");
                            if (!player.getUsesMp()) {
                                player.setStamina(player.getMaxStamina());
                                System.out.println("\nYour stamina has been fully restored.");
                            } else {
                                player.setMp(player.getMaxMp());
                                System.out.println("\nYour MP has been fully restored.");
                            }
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
                    Item[] inventory = player.getInventory();
                    boolean isEmpty = true;
                    if (inventory != null && inventory.length > 0) {
                        for (int i = 0; i < inventory.length; i++) {
                            if (inventory[i] != null) {
                                isEmpty = false;
                                break;
                            }
                        }
                    }
                    if (inventory == null || isEmpty) {
                        System.out.println("Your inventory is empty!");
                    }
                    else {
                        player.showInventory();
                        System.out.println("\n========================================================================================================================================================\n");
                    }
                    break;

                case 5:
                    System.out.println("Returning to main menu...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
