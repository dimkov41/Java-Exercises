package CoffeeMachine;

import java.util.*;

public class CoffeeMachine {
    private List<Coffee> coffes;
    private int totalCoins;

    public CoffeeMachine() {
        this.coffes = new ArrayList<>();
    }

    public List<Coffee> getCoffes() {
        return coffes;
    }

    public void buyCoffee(String size, String type){
        CoffeeSize coffeSize = Enum.valueOf(CoffeeSize.class,size.toUpperCase());

        if(totalCoins > coffeSize.getPrice()) {
            coffes.add(new Coffee(size, type));
            totalCoins -= coffeSize.getPrice();
        }

    }

    public void insertCoin(String coin){
        Coin c = Enum.valueOf(Coin.class,coin.toUpperCase());

        totalCoins += c.getValue();
    }

   public Iterable<Coffee> coffeesSold(){
        return CoffeeIterator::new;
   }

   private final class CoffeeIterator implements Iterator<Coffee>{
        private int counter = 0;

       @Override
       public boolean hasNext() {
           return counter < coffes.size();
       }

       @Override
       public Coffee next() {
           return coffes.get(counter++);
       }
   }

}
