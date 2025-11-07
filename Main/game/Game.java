package Main.game;

import Main.game.GameMenu;

public class Game {
    private GameMenu menu;

    public Game() {
        menu = new GameMenu();
    }
   
    public void start() {
        System.out.println("Game Starting...");
        System.out.println();
		menu.showMainMenu();
    }
}