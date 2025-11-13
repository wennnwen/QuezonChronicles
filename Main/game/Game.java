package Main.game;

import Main.game.GameMenu;

public class Game {
    private GameMenu menu;

    public Game() {
        menu = new GameMenu();
    }
   
    public void start() {
        int choice = 0;
        System.out.println("Game Start!");
        System.out.println("==============================================================================================");
        System.out.println("QUEZON CHRONICLES\n");
        System.out.println("Start\nAbout\nExit")
        System.out.println("==============================================================================================");
        
        switch (choice) {
            case 1:
                menu.showMainMenu();
                break;
            case 2:
                System.out.println("About the Game: \nQuezon Chronicles is an epic RPG adventure set in the Philippines. \nEmbark on a journey through rich landscapes, 
                                    \nencountering mythical creatures and historical figures. \nUncover the secrets of the archipelago while battling foes, \nsolving puzzles, 
                                    and forging alliances. \nExperience a unique blend of Filipino culture and mythology in this captivating quest for glory!");
                break;
            case 3:
                System.out.println("Exiting the game. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}