package ConsumerPrint;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] input = scanner.nextLine().split("\\s+");

        for (String s : input) {
            Consumer<String> print = System.out::println;
            print.accept(s);
        }


    }
}
