package entity;

import main.Console;
import objects.items.Item_Money;
import objects.items.Item_Weapon;

import java.util.Scanner;

public class Enemy {
    private final int damage;
    private int health = 100;
    private boolean death = false;

    public Enemy(int damage) {
        this.damage = damage;
    }

    public String attack(Console console) {
        String out = "";
        int indexOfWeapon = console.getPlayer().hasItem(Item_Weapon.class);
        if (indexOfWeapon != -1) {
            Item_Weapon weapon = (Item_Weapon) console.getPlayer().getItemList().get(indexOfWeapon);
            console.getPlayer().removeItem(weapon);
            health -= weapon.getDamage();
            out += "enemy attacked by weapon\ndamage dealt: " + weapon.getDamage();
        } else {
            health -= console.getPlayer().getDefaultDamage();
            out += "enemy attacked by hand\ndamage dealt: " + console.getPlayer().getDefaultDamage();
        }

        if (health <= 0) {
            death = true;
            console.getWorld().getCurrentLocation().killEntity();
            out += "\nentity was killed";
        }

        if (!death) {
            console.getPlayer().removeHealth(damage);
            out += "\ndamage taken: " + damage;
        }

        return out;
    }

    public String talk(Console console) {
        System.out.println("hey you! if you give me money i will let you be the king!\ndo you want to give the enemy money? (yes/no)");
        Scanner scn = new Scanner(System.in);
        String input = scn.next();

        if (input.equals("yes")) {
            int indexOfItem = console.getPlayer().hasItem(Item_Money.class);
            if (indexOfItem != -1) {
                console.getPlayer().getItemList().remove(indexOfItem);
                console.getWorld().getCurrentLocation().killEntity();
                return "the enemy is now your friend";
            } else {
                return "you dont have money";
            }
        } else {
            return "the enemy is still your enemy";
        }
    }
}
