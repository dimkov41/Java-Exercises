package PredicateForNames;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wordLenght = Integer.parseInt(scanner.nextLine());

        String[] words = scanner.nextLine().split(" ");

        Predicate<String> checkLenght = str -> str.length() <= wordLenght;

        for (String currentWord : words) {
            if(checkLenght.test(currentWord)){
                System.out.println(currentWord);
            }
        }
    }
}
