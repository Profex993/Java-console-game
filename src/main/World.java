package main;

import entity.Player;
import objects.Location;

import java.util.ArrayList;

public class World {
    private Location currentLocation;
    private final ArrayList<Location> locationList;

    public World(Player player) {
        locationList = Loader.load(player);
        currentLocation = locationList.get(0);
    }

    public String getCurrent() {
        return currentLocation.getName() + "\nitems " + currentLocation.getItemList().toString() +
                "\nnorth: " + ((currentLocation.getNorth() != null) ? currentLocation.getNorth().getName() : " ") +
                "\nsouth: " + ((currentLocation.getSouth() != null) ? currentLocation.getSouth().getName() : " ") +
                "\nwest: " + ((currentLocation.getWest() != null) ? currentLocation.getWest().getName() : " ") +
                "\neast: " + ((currentLocation.getEast() != null) ? currentLocation.getEast().getName() : " ");
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public ArrayList<Location> getLocationList() {
        return locationList;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Location loc: locationList) {
            out.append(loc.toString()).append("\n");
        }
        return out.toString();
    }
}
