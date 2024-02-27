package entity;

import objects.items.Item;

import java.util.ArrayList;

public class Player {
    private int health = 100;
    private boolean death = false;
    private final ArrayList<Item> itemList = new ArrayList<>();

    public Player() {
    }

    public void addItem(ArrayList<Item> itemListAdd) {
        itemList.addAll(itemListAdd);
    }

    public int hasItem(Class<? extends Item> itemClass) {
        for (Item item : itemList) {
            if (itemClass.isInstance(item)) {
                return itemList.indexOf(item);
            }
        }
        return -1;
    }

    public void removeItem(Item add) {
        itemList.remove(add);
    }

    public void useItem(int index) {
        itemList.get(index).execute();
    }

    public void removeHealth(int remove) {
        health -= remove;

        if (health <= 0) {
            death = true;
        }
    }

    public void addHealth(int add) {
        health += add;
        if (health > 100) health = 100;
    }

    public int getHealth() {
        return health;
    }

    public int getDefaultDamage() {
        return 20;
    }

    public boolean isDeath() {
        return death;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }
}
