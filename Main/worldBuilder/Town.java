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
import Main.styles.textColor.TextColorHub;

public class Town {
    private String name;
    private String description;
    private Enemy[] enemies;
    private Enemy boss;
    private Town nextTown;
    private CenterHub centerHub = new CenterHub();
    private TypeWriter typeWriter = new TypeWriter();
    private LoadingDots loadingDots = new LoadingDots();
    private TextColorHub textColor = new TextColorHub();

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
        System.out.println("\n====================================================================== " + textColor.GREEN + name.toUpperCase() + textColor.RESET + " =======================================================================\n");
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
            System.out.println("\n======================================================================= " + textColor.GREEN + "OPTIONS" + textColor.RESET + " =====================================================================");
            System.out.println(textColor.RED + "Enemies left: " + remaining + textColor.RESET);
            centerHub.printCenteredText(textColor.RED + "( 1 ) Explore / Battle" + textColor.RESET);
            centerHub.printCenteredText(textColor.GREEN + "( 2 ) Move to next town" + textColor.RESET);
            centerHub.printCenteredText(textColor.BLUE + "( 3 ) Check player stats" + textColor.RESET);
            centerHub.printCenteredText(textColor.YELLOW + "( 4 ) Inventory" + textColor.RESET);
            centerHub.printCenteredText(textColor.PURPLE + "( 5 ) Exit to main menu" + textColor.RESET);
            System.out.println("=====================================================================================================================================================");
            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (enemies != null && enemiesDefeated < enemies.length) {
                        ClearScreen.clear();
                        Enemy enemy = enemies[enemiesDefeated];
                        String text = "A wild " + enemy.getName() + " appeared!";
                        typeWriter.typeWriterFast(textColor.GREEN + text + textColor.RESET);
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
                            loadingDots.loadingDotsAnimation(textColor.GREEN + text + textColor.RESET);
                            ClearScreen.clear();
                            text = "You've just arrived in " + nextTown.name;
                            typeWriter.typeWriterFast(textColor.GREEN + text + textColor.RESET);
                            if (!player.getUsesMp()) {
                                player.setStamina(player.getMaxStamina());
                                typeWriter.typeWriterFast(textColor.ORANGE + "\nYour stamina has been fully restored." + textColor.RESET);
                            } else {
                                player.setMp(player.getMaxMp());
                                typeWriter.typeWriterFast(textColor.BLUE + "\nYour MP has been fully restored." + textColor.RESET);
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
                        typeWriter.typeWriterFast(textColor.RED + "You must defeat all enemies before moving on!" + textColor.RESET);
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
                    System.out.println();
                    return;

                default:
                    ClearScreen.clear();
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
