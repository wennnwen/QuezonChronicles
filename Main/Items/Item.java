package Main.Items;

Import Main.Character.Player.Player;

public class Item {
    private String name, description;

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