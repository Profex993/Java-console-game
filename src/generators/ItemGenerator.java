package generators;

import entity.Player;
import objects.items.*;

import java.util.Random;

public class ItemGenerator {
    private static final Random rnd = new Random();
    private static final int maxItem = 3;
    public static Item generateItem(Player player) {
        return switch (rnd.nextInt(maxItem)) {
            case 0 -> new Item_Bandage(player);
            case 1 -> new Item_Weapon();
            case 2 -> new Item_Money();
            default -> null;
        };
    }
}
