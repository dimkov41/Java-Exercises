package MinEvenNumber;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class MinEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OptionalDouble nums = Arrays.stream(scanner.nextLine().split(" "))
                .filter(x -> !x.isEmpty())
                .mapToDouble(Double::parseDouble)
                .filter(x->x % 2 == 0)
                .min();

        if(nums.isPresent()){
            System.out.printf("%.2f",nums.getAsDouble());
        }
        else{
            System.out.println("No match");
        }
    }
}
