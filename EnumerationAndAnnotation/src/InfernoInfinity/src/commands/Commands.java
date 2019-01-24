package commands;

import enums.WeaponType;
import models.Weapon;

import java.util.LinkedList;
import java.util.List;

public class Commands {
    private List<Weapon> weapons;

    public Commands() {
        weapons = new LinkedList<>();
    }

    public void createWeapon(String weaponEnum, String name) {
        try {
            //create if not exist
            if (weapons.stream().noneMatch(x -> x.getName().equalsIgnoreCase(name))) {
            this.weapons.add(new Weapon(Enum.valueOf(WeaponType.class, weaponEnum.toUpperCase()), name));
            }
        } catch (IllegalArgumentException e) {
        }
    }

    public void addGemToWeapon(String weaponName, int index, String gemName) {
        for (Weapon weapon : weapons) {
            if (weapon.getName().equalsIgnoreCase(weaponName)) {
                weapon.setGems(index, gemName);
                break;
            }
        }
    }

    public void removeGemFromWeapon(String weaponName, int index) {
        for (Weapon weapon : weapons) {
            if (weapon.getName().equalsIgnoreCase(weaponName)) {
                weapon.removeGems(index);
                break;
            }
        }
    }

    //{weapon's name}: {min damage}-{max damage} Damage, +{points} Strength, +{points} Agility, +{points} Vitality
    public String print(String weaponName) {
        Weapon weapon = new Weapon();
        for (Weapon w : weapons) {
            if (w.getName().equalsIgnoreCase(weaponName)) {
                weapon = w;
            }
        }
        return weapon.toString();
    }

    public String compareWeapons(String firstWeaponName, String secondWeaponName) {
        Weapon firstWeapon = new Weapon();
        Weapon secondWeapon = new Weapon();

        for (Weapon weapon : weapons) {
            if (firstWeaponName.equalsIgnoreCase(weapon.getName()))
                firstWeapon = weapon;
            else if (secondWeaponName.equalsIgnoreCase(weapon.getName()))
                secondWeapon = weapon;
        }

        if (firstWeapon != null && secondWeapon != null) {
            int comparator = firstWeapon.compareTo(secondWeapon);
            if (comparator > 0) {
                return String.format("%s (Item Level: %.1f)", firstWeapon.toString(), firstWeapon.getItemLevel());

            } else if (comparator < 0) {
                return String.format("%s (Item Level: %.1f)", secondWeapon.toString(), secondWeapon.getItemLevel());
            }

        }
        return String.format("%s (Item Level: %.1f)", firstWeapon.toString(), firstWeapon.getItemLevel());
    }
}
