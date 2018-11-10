package KnightsOfHonor;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        for (String s : input) {
            Consumer<String> print = i -> System.out.println("Sir " + i);
            print.accept(s);
        }
    }
}
