package commands;

import main.Console;
import objects.items.Item_Bandage;

public class Command_UseBandage implements Command {
    @Override
    public String execute(Console console) {
        int indexOfBandage = console.getPlayer().hasItem(Item_Bandage.class);
        if (indexOfBandage != -1) {
            console.getPlayer().useItem(indexOfBandage);
            return "bandage used\nyour health is now " + console.getPlayer().getHealth();
        }
        return "no bandage";
    }
}
