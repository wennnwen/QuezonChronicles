package Main.item;

import Main.character.player.Player;
import Main.styles.textColor.TextColorHub;

public abstract class Item {
    private String name, description;
    protected TextColorHub textColor = new TextColorHub();

    public abstract void useItem(Player player);

    //getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //setters
    public void setName(String newName) {
        name = newName;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }
}