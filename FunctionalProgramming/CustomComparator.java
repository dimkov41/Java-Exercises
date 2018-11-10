package CustomComparator;

        import java.text.CollationElementIterator;
        import java.util.*;
        import java.util.function.Function;
        import java.util.function.Predicate;
        import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int[] evenNums = Arrays.stream(input)
                .filter(x -> x.length() > 0)
                .mapToInt(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .toArray();

        int[] oddNums = Arrays.stream(input)
                .filter(x -> x.length() > 0)
                .mapToInt(Integer::parseInt)
                .filter(x -> x % 2 != 0)
                .toArray();

        Arrays.sort(evenNums);
        Arrays.sort(oddNums);


        for (int evenNum : evenNums) {
            System.out.printf("%d ",evenNum);
        }

        for (int oddNum : oddNums) {

            System.out.printf("%d ",oddNum);
        }
    }
}
