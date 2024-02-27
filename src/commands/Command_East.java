package commands;

import main.Console;

public class Command_East implements Command{
    @Override
    public String execute(Console console) {
        if (console.getWorld().getCurrentLocation().getEast() != null) {
            console.getWorld().setCurrentLocation(console.getWorld().getCurrentLocation().getEast());
            return "moved east\n" + console.getWorld().getCurrent();
        }
        return "you cant go east";
    }
}
