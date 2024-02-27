package commands;

import main.Console;

public class Command_Help implements Command {
    @Override
    public String execute(Console console) {
        return console.getCommandList().keySet().toString();
    }
}
