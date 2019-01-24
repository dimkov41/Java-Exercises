package enums;



import java.lang.annotation.Documented;

public enum Gem {
    RUBY(7,2,5),EMERALD(1,4,9),AMETHYST(2,8,4);

    private int strength;
    private int agility;
    private int vitality;

    Gem(int strength, int agility, int vitality) {
        this.strength = strength;
        this.agility = agility;
        this.vitality = vitality;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }
}
