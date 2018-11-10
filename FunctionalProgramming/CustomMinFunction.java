package CustomMinFunctin;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//        Integer[] nums = new Integer[input.length];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = Integer.valueOf(input[i]);
//        }

        Function<Integer[],Integer> fuct = i -> {
            Arrays.sort(i);

            return i[0];
        };

        System.out.println(fuct.apply(Arrays.stream(input).boxed().toArray(Integer[]::new)));
    }
}
