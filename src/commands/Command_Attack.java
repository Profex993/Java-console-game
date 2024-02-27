package commands;

import main.Console;

public class Command_Attack implements Command {
    @Override
    public String execute(Console console) {
        if (console.getWorld().getCurrentLocation().getEntity() != null) {
            return console.getWorld().getCurrentLocation().getEntity().attack(console);
        } else {
            return "no entity here";
        }
    }
}
