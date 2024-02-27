package commands;

import main.Console;

public class Command_health implements Command{
    @Override
    public String execute(Console console) {
        return "your health is: " + console.getPlayer().getHealth();
    }
}
