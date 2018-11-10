package AppliedArithmetic;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Function<Integer[],Integer[]> addFunct = arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i]++;
            }
            return arr;
        };

        Function<Integer[],Integer[]> multiplyFunct = arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i]*=2;
            }
            return arr;
        };

        Function<Integer[],Integer[]> subtractFunct = arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i]--;
            }
            return arr;
        };

        Consumer<Integer[]> print = arr ->{
            StringBuilder builder = new StringBuilder();
            Arrays.stream(arr).forEach(i -> builder.append(i).append(" "));
            System.out.println(builder.toString());
        };

        while(true){
            String command = scanner.nextLine();

            if(command.equals("end"))
                break;

            if(command.equals("add")){
                nums = addFunct.apply(nums);
            }
            else if(command.equals("multiply")){
                nums = multiplyFunct.apply(nums);
            }
            else if(command.equals("subtract")){
                nums = subtractFunct.apply(nums);
            }
            else if(command.equals("print")){
                print.accept(nums);
            }

        }
    }
}
