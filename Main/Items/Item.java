public class Item {
    private String name, description;

    public abstract void useItem(Player player);

    //getters
    public void getName() {
        return name;
    }

    public void getDescription() {
        return description;
    }

    //setters
    public String setName(String newName) {
        this.name = newName;
    }

    public String setDescription(String newDescription) {
        this.description = newDescription;
    }
}