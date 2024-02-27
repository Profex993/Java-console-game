package commands;

import main.Console;

public class Command_West implements Command {
    @Override
    public String execute(Console console) {
        if (console.getWorld().getCurrentLocation().getWest() != null) {
            console.getWorld().setCurrentLocation(console.getWorld().getCurrentLocation().getWest());
            return "moved north\n" + console.getWorld().getCurrent();
        }
        return "you cant go west";
    }
}
