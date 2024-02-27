package objects.items;

public class Item {
    protected final String name;

    public Item(String name) {
        this.name = name;
    }

    public void execute() {

    }

    @Override
    public String toString() {
        return name;
    }
}
