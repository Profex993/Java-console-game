package objects;

import entity.Enemy;
import objects.items.Item;

import java.util.ArrayList;

public class Location {
    private Location north, south, west, east;
    private final String name;
    private final ArrayList<Item> itemList;
    private Enemy enemy;
    private boolean entityIsDead = false;

    public Location(String name, ArrayList<Item> itemList, Enemy enemy) {
        this.name = name;
        this.itemList = itemList;
        this.enemy = enemy;
    }

    public void setNorth(Location north) {
        this.north = north;
    }

    public void setSouth(Location south) {
        this.south = south;
    }

    public void setWest(Location west) {
        this.west = west;
    }

    public void setEast(Location east) {
        this.east = east;
    }

    public Location getNorth() {
        return north;
    }

    public Location getSouth() {
        return south;
    }

    public Location getWest() {
        return west;
    }

    public Location getEast() {
        return east;
    }

    public String getName() {
        return name;
    }

    public Enemy getEntity() {
        return enemy;
    }

    public void killEntity() {
        this.enemy = null;
        this.entityIsDead = true;
    }

    public boolean isEntityIsDead() {
        return entityIsDead;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    @Override
    public String toString() {

        return "you are in: " + name + ((north != null) ? "\nnorth: " + north.getName() : " ") +
                ((south != null) ? "\nsouth: " + south.getName() : " ") +
                ((west != null) ? "\nwest: " + west.getName() : " ") +
                ((east != null) ? "\neast: " + east.getName() : " ") +
                "\nitems: " + itemList.toString() + "\nentity: " + ((isEntityIsDead()) ? "entity is dead" : "entity is alive");
    }
}
