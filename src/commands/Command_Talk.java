package commands;

import main.Console;

public class Command_Talk implements Command {
    @Override
    public String execute(Console console) {
        return console.getWorld().getCurrentLocation().getEntity().talk(console);
    }
}
