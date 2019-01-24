package CoffeeMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeMachine coffeMachine = new CoffeeMachine();

        System.out.println();

        while(true){
            String str = scanner.nextLine();
            if(str.equalsIgnoreCase("End"))
                break;

            String[] input = str.split("\\s+");

            if(input.length == 1){
                coffeMachine.insertCoin(input[0]);

            }else if(input.length == 2){
                coffeMachine.buyCoffee(input[0],input[1]);
            }
        }


        for (Coffee coffes : coffeMachine.coffeesSold()) {
            System.out.println(coffes);
        }
    }
}
