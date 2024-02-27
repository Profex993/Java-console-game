package main;

import commands.Command;
import entity.Player;
import generators.CommandGenerator;
import objects.Location;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private final HashMap<String, Command> commandList;
    private final Player player = new Player();
    private final World world = new World(player);
    private boolean loopActive = true;

    public Console() {
        commandList = CommandGenerator.generateCommandList();
        startLoop();
    }

    public void startLoop() {
        Scanner scn = new Scanner(System.in);
        System.out.println("You are trying to become the king.\nKill all enemies to become the king!!!\nwrite help to get list of commands.");
        System.out.println(world.getCurrentLocation().toString());

        while (loopActive && !player.isDeath() && !checkForGameEnd()) {
            String input = scn.nextLine();
            Command command = commandList.get(input);

            if (command != null) {
                System.out.println(command.execute(this));
            } else {
                System.out.println("invalid command");
            }
        }

        if (checkForGameEnd()) {
            System.out.println("You have become the king!!!");
        } else if (player.isDeath()) {
            System.out.println("you died (rip)");
        }
    }

    private boolean checkForGameEnd() {
        boolean check = true;
        for (Location loc: world.getLocationList()) {
            if (!loc.isEntityIsDead()) {
                check = false;
                break;
            }
        }
        return check;
    }

    public void stopLoop() {
        loopActive = false;
    }

    public World getWorld() {
        return world;
    }

    public Player getPlayer() {
        return player;
    }

    public HashMap<String, Command> getCommandList() {
        return commandList;
    }
}
