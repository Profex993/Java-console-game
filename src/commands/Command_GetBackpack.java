package commands;

import main.Console;

public class Command_GetBackpack implements Command{
    @Override
    public String execute(Console console) {
        return console.getPlayer().getItemList().toString();
    }
}
