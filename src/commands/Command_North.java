package commands;

import main.Console;

public class Command_North implements Command {
    @Override
    public String execute(Console console) {
        if (console.getWorld().getCurrentLocation().getNorth() != null) {
            console.getWorld().setCurrentLocation(console.getWorld().getCurrentLocation().getNorth());
            return "moved north\n" + console.getWorld().getCurrent();
        }
        return "you cant go north";
    }
}
