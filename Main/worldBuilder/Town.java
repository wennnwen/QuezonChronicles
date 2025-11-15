package Main.worldBuilder;

import java.util.Scanner;
import Main.character.enemy.Enemy;
import Main.character.Character;
import Main.character.player.Player;
import Main.game.BattleSystem;
import Main.item.*;
import Main.styles.printAlignmentHub.CenterHub;
import Main.styles.clearScreen.ClearScreen;
import Main.styles.animationHub.TypeWriter;
import Main.styles.animationHub.LoadingDots;

public class Town {
    private String name;
    private String description;
    private Enemy[] enemies;
    private Enemy boss;
    private Town nextTown;
    private CenterHub centerHub = new CenterHub();
    private TypeWriter typeWriter = new TypeWriter();
    private LoadingDots loadingDots = new LoadingDots();

    public Town(String name, String description, Enemy[] enemies, Enemy boss) {
        this.name = name;
        this.description = description;
        this.enemies = enemies;
        this.boss = boss;
    }

    public void setNextTown(Town nextTown) {
        this.nextTown = nextTown;
    }

    public Town getNextTown() {
        return this.nextTown;
    }

    public void enterTown(Player player, int townIndex) {
        System.out.println("\n====================================================================== " + name.toUpperCase() + " =======================================================================\n");
        centerHub.printCenteredTextWithTypeWriter(description);

        // Load progress if returning to this town
        int enemiesDefeated = (player.getCurrentTownIndex() == townIndex) ? player.getEnemiesDefeatedInTown() : 0;
        player.setCurrentTownIndex(townIndex);
        
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
            System.out.println("\n======================================================================= OPTIONS =====================================================================");
            System.out.println("Enemies left: " + remaining);
            centerHub.printCenteredText("( 1 ) Explore / Battle");
            centerHub.printCenteredText("( 2 ) Move to next town");
            centerHub.printCenteredText("( 3 ) Check player stats");
            centerHub.printCenteredText("( 4 ) Inventory");
            centerHub.printCenteredText("( 5 ) Exit to main menu");
            System.out.println("=====================================================================================================================================================");
            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (enemies != null && enemiesDefeated < enemies.length) {
                        ClearScreen.clear();
                        Enemy enemy = enemies[enemiesDefeated];
                        String text = "A wild " + enemy.getName() + " appeared!";
                        typeWriter.typeWriterFast(text);
                        new BattleSystem().BattleStart(player, enemy);
                        enemiesDefeated++;
                        player.setEnemiesDefeatedInTown(enemiesDefeated);
                    } else if (boss != null && enemiesDefeated == (enemies != null ? enemies.length : 0)) {
                        ClearScreen.clear();
                        typeWriter.typeWriterFast("\nYou've reached the boss battle!");
                        typeWriter.typeWriterFast("\nThe boss of " + name + " appears: " + boss.getName() + "!");
                        new BattleSystem().BattleStart(player, boss);
                        enemiesDefeated++;
                        player.setEnemiesDefeatedInTown(enemiesDefeated);
                        typeWriter.typeWriterFast("You've cleared " + name + "!");
                    } else {
                        ClearScreen.clear();
                        typeWriter.typeWriterFast("You’ve already cleared all enemies here!");
                    }
                    break;

                case 2:
                    if ((boss == null && enemiesDefeated >= 3) || (boss != null && enemiesDefeated >= 3)) {
                        if (nextTown != null) {
                            ClearScreen.clear();
                            String text = "Preparing to travel to " + nextTown.name;
                            loadingDots.loadingDotsAnimation(text);
                            ClearScreen.clear();
                            text = "You've just arrived in " + nextTown.name;
                            typeWriter.typeWriterFast(text);
                            if (!player.getUsesMp()) {
                                player.setStamina(player.getMaxStamina());
                                typeWriter.typeWriterFast("\nYour stamina has been fully restored.");
                            } else {
                                player.setMp(player.getMaxMp());
                                typeWriter.typeWriterFast("\nYour MP has been fully restored.");
                            }
                            player.setEnemiesDefeatedInTown(0); // Reset for new town
                            nextTown.enterTown(player, townIndex + 1);
                            return;
                        } else {
                            ClearScreen.clear();
                            typeWriter.typeWriterFast("You've reached the end of your journey!");
                            player.setChosenPath(null); // Allow new path selection after completion
                            player.setCurrentTownIndex(0);
                            player.setEnemiesDefeatedInTown(0);
                            return;
                        }
                    } else {
                        ClearScreen.clear();
                        typeWriter.typeWriterFast("You must defeat all enemies before moving on!");
                    }
                    break;

                case 3:
                    ClearScreen.clear();
                    player.showStats();
                    break;

                case 4: 
                    ClearScreen.clear();
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
                        System.out.println("\n========================================================================================================================================================");
                    }
                    break;

                case 5:
                    loadingDots.customLoadingDotsAnimation("Returning to main menu", 3, 500, 5000);
                    return;

                default:
                    ClearScreen.clear();
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
