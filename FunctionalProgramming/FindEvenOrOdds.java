package FindEvenOrOdds;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);

        String typeOfNums = scanner.nextLine();

        Predicate<Integer> isOdd = i -> i % 2 != 0;

        StringBuilder builder = new StringBuilder();

        for (int i = lowerBound; i <= upperBound; i++) {
            if (typeOfNums.equals("odd")) {
                if (isOdd.test(i)) {
                    builder.append(i).append(" ");
                }
            } else if (typeOfNums.equals("even")) {
                if(!isOdd.test(i)){
                    builder.append(i).append(" ");
                }
            }
        }

        System.out.println(builder.toString());

    }
}
