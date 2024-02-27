package main;

import entity.Enemy;
import entity.Player;
import generators.EntityGenerator;
import generators.ItemGenerator;
import objects.items.Item;
import objects.Location;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Loader {
    private final static File file = new File("./data.csv");
    private final static int maxItemNum = 2;

    public static void save(ArrayList<Location> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Location location : list) {
                bw.write(location.getName());
                bw.newLine();
            }

            bw.write("PATHS");
            bw.newLine();

            for (Location location : list) {
                saveLocation(location.getNorth(), bw);
                saveLocation(location.getSouth(), bw);
                saveLocation(location.getWest(), bw);
                saveLocation(location.getEast(), bw);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveLocation(Location loc, BufferedWriter bw) {
        try {
            if (loc != null) {
                bw.write(loc.getName());
            } else {
                bw.write("null");
            }
            bw.newLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Location> load(Player player) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Random rnd = new Random();
            ArrayList<Location> locationList = new ArrayList<>();
            String line = br.readLine();
            while (line != null && !line.equals("PATHS")) {
                ArrayList<Item> itemList = new ArrayList<>();
                for (int i = 0; i < rnd.nextInt(maxItemNum) + 1; i++) {
                    itemList.add(ItemGenerator.generateItem(player));
                }
                Enemy enemy = EntityGenerator.generateEntity();
                locationList.add(new Location(line, itemList, enemy));
                line = br.readLine();
            }

            for (Location location: locationList) {
                String line2 = br.readLine();
                if (!line2.equals("null")) {
                    location.setNorth(locationList.get(getLocationIndex(line2, locationList)));
                }
                line2 = br.readLine();
                if (!line2.equals("null")) {
                    location.setSouth(locationList.get(getLocationIndex(line2, locationList)));
                }
                line2 = br.readLine();
                if (!line2.equals("null")) {
                    location.setWest(locationList.get(getLocationIndex(line2, locationList)));
                }
                line2 = br.readLine();
                if (!line2.equals("null")) {
                    location.setEast(locationList.get(getLocationIndex(line2, locationList)));
                }
            }
            return locationList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getLocationIndex(String name, ArrayList<Location> list) {
        for (Location loc: list) {
            if (name.equals(loc.getName())) {
                return list.indexOf(loc);
            }
        }
        throw new RuntimeException("undefined map");
    }
}
