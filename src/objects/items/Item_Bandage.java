package objects.items;

import entity.Player;

public class Item_Bandage extends Item {
    private final Player player;

    public Item_Bandage(Player player) {
        super("Bandage");
        this.player = player;
    }

    @Override
    public void execute() {
        int addHealth = 50;
        player.addHealth(addHealth);
        player.getItemList().remove(this);
    }
}
