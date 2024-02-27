package commands;

import main.Console;

public class Command_Exit implements Command {
    @Override
    public String execute(Console console) {
        console.stopLoop();
        return "Good bye";
    }
}
