package Main;

import Main.GameMenu;

public class Game {
    private GameMenu menu;

    public Game() {
        menu = new GameMenu();
    }
   
    public void start() {
        System.out.println("Game Starting...");
		menu.showMainMenu();
    }
}