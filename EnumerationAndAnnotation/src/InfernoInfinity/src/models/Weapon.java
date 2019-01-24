package models;

import enums.Gem;
import enums.WeaponType;

@annotations.Weapon(author = "Pesho",
        revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"})
public class Weapon implements Comparable<Weapon> {
    private final int MIN_DAMAGE_STRENGHT = 2;
    private final int MAX_DAMAGE_STRENGHT = 3;
    private final int MAX_DAMAGE_AGILITY = 4;

    private WeaponType weapon;
    private String name;
    private Gem[] gems;
    private double itemLevel;

    public Weapon() {
    }

    public Weapon(WeaponType weapon, String name) {
        this.weapon = weapon;
        this.name = name;
        this.gems = new Gem[weapon.getSockets()];
    }

    public WeaponType getWeapon() {
        return weapon;
    }

    public String getName() {
        return name;
    }

    public double getItemLevel() {
        this.itemLevel = ((this.weapon.getMinDamage() + this.weapon.getMaxDamage()) / 2F)
                + this.getStrength() + this.getAgility() + this.getVitality();
        return itemLevel;
    }



    //Every point of strength adds +2 to min damage and +3 to max damage. Every point of agility adds +1 to min damage and +4 to max damage.

    public void setGems(int index, String gemName) {
        try {
            if (index < this.gems.length) {
                Gem gem = Enum.valueOf(Gem.class, gemName.toUpperCase());

                //if slot is occupied I need to override wiith new gem
                if (this.gems[index] != null) {
                    //I need to remove the current gem and remove powers that it's give to weapon
                    this.removeGemPowers(this.gems[index]);
                    //then setValues with new gem
                    this.setGemPowers(gem);
                    this.gems[index] = gem;
                }
                //if slot is FREE(null)
                else {
                    this.gems[index] = gem;
                    this.setGemPowers(this.gems[index]);
                }
            }
        } catch (IllegalArgumentException a) {
        }
    }

    public void removeGems(int index) {
        try {
            if (index < this.gems.length) {
                if(gems[index] != null) {
                    this.removeGemPowers(gems[index]);
                    this.gems[index] = null;
                }
            }
        } catch (NullPointerException | IllegalArgumentException ignored) {}
    }


    protected int getStrength() {
        int strenght = 0;
        for (Gem gem : gems) {
            if (gem != null)
                strenght += gem.getStrength();
        }
        return strenght;
    }

    protected int getAgility() {
        int agility = 0;
        for (Gem gem : gems) {
            if (gem != null)
                agility += gem.getAgility();
        }
        return agility;
    }

    protected int getVitality() {
        int vitality = 0;
        for (Gem gem : gems) {
            if (gem != null)
                vitality += gem.getVitality();
        }
        return vitality;
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(),
                this.getWeapon().getMinDamage(),
                this.getWeapon().getMaxDamage(),
                this.getStrength(),
                this.getAgility(),
                this.getVitality());
    }

    private void removeGemPowers (Gem gem) {
        this.weapon.setMinDamage(this.weapon.getMinDamage() - ((gem.getStrength() * MIN_DAMAGE_STRENGHT) + (gem.getAgility())));
        this.weapon.setMaxDamage(this.weapon.getMaxDamage() - ((gem.getStrength() * MAX_DAMAGE_STRENGHT) + (gem.getAgility() * MAX_DAMAGE_AGILITY)));
    }

    private void setGemPowers(Gem gem) {
        this.weapon.setMinDamage(this.weapon.getMinDamage() + (gem.getStrength() * MIN_DAMAGE_STRENGHT) + (gem.getAgility()));
        this.weapon.setMaxDamage(this.weapon.getMaxDamage() + (gem.getStrength() * MAX_DAMAGE_STRENGHT) + (gem.getAgility() * MAX_DAMAGE_AGILITY));
    }

    @Override
    public int compareTo(Weapon o) {
        return Double.compare(this.getItemLevel(), o.getItemLevel());
    }
}
