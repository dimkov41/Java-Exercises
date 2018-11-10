import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int upperBound = bounds[1];
        int lowerBound = bounds[0];

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(x -> x <= upperBound && x >= lowerBound)
                .toArray();

        Arrays.stream(numbers).forEach(x -> System.out.printf("%d ",x));
    }

}
