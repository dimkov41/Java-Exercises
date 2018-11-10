package FindTheSmallestElement;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Integer[] unsortedArr = new Integer[nums.length];
        for (int i = 0; i < unsortedArr.length; i++) {
            unsortedArr[i] = nums[i];
        }

        Function<Integer[],Integer> findSmallestNum = arr ->{
            Arrays.sort(arr);

            int index = 0;
            for (int i = 0; i < unsortedArr.length; i++) {
                if(unsortedArr[i] == arr[0])
                    index = i;
            }
            return index;
        };

        System.out.println(findSmallestNum.apply(nums));

    }
}
