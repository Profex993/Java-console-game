package commands;

import main.Console;

public class Command_PickUp implements Command {
    @Override
    public String execute(Console console) {
        console.getPlayer().addItem(console.getWorld().getCurrentLocation().getItemList());
        console.getWorld().getCurrentLocation().getItemList().clear();
        return "items stolen";
    }
}
