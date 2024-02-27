package commands;

import main.Console;

public class Command_South implements Command{
    @Override
    public String execute(Console console) {
        if (console.getWorld().getCurrentLocation().getSouth() != null) {
            console.getWorld().setCurrentLocation(console.getWorld().getCurrentLocation().getSouth());
            return "moved south\n" + console.getWorld().getCurrent();
        }
        return "cant go south";
    }
}
