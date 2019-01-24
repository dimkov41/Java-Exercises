package CoffeeMachine;

public class Coffee {
    private CoffeeSize coffeSize;
    private CoffeeType coffeType;


    public Coffee(String coffeSize, String coffeType) {
        this.coffeSize = Enum.valueOf(CoffeeSize.class,coffeSize.toUpperCase());
        this.coffeType = Enum.valueOf(CoffeeType.class,coffeType.toUpperCase());
    }


    @Override
    public String toString() {
        return String.format("%s %s",coffeSize,coffeType);
    }
}
