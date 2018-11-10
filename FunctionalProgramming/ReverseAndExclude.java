package ReverseAndExclude;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        int divisableNum = Integer.parseInt(scanner.nextLine());

        Function<Integer[], Integer[]> reverseArr = arr -> {
            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = temp;
            }
            return arr;
        };

        nums = reverseArr.apply(nums);

        Predicate<Integer> isDivisible = i -> i % divisableNum == 0;

        for (Integer i:nums){
            if(isDivisible.test(i)){
                nums = removeElements(nums,i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ",nums[i]);
        }
    }

    public static Integer[] removeElements(Integer[] input, Integer deleteMe) {
        List<Integer> result = new LinkedList();

        for(Integer item : input)
            if(!deleteMe.equals(item))
                result.add(item);

        return result.toArray(new Integer[result.size()]);
    }
}
