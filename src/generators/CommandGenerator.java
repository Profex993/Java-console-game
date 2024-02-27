package generators;

import commands.*;

import java.util.HashMap;

public class CommandGenerator {
    private static final HashMap<String, Command> commandList = new HashMap<>();

    public static HashMap<String, Command> generateCommandList() {
        commandList.put("north", new Command_North());
        commandList.put("south", new Command_South());
        commandList.put("west", new Command_West());
        commandList.put("east", new Command_East());
        commandList.put("steal", new Command_PickUp());
        commandList.put("backpack", new Command_GetBackpack());
        commandList.put("attack", new Command_Attack());
        commandList.put("talk", new Command_Talk());
        commandList.put("health", new Command_health());
        commandList.put("use bandage", new Command_UseBandage());
        commandList.put("help", new Command_Help());
        commandList.put("exit", new Command_Exit());

        return commandList;
    }
}
