package CustomStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack<Integer> stack = new CustomStack<Integer>();

        while (true) {
            String str = scanner.nextLine();

            if (str.equalsIgnoreCase("END")) {

                for (int i = 0; i < 2; i++) {
                    for (Integer integer : stack) {
                        if (integer != null)
                            System.out.println(integer);
                    }
                }
                break;
            }

            String[] input = str.split("[,\\s+]+");
            String command = input[0];
            if (command.equalsIgnoreCase("Push")) {
                for (int i = 1; i < input.length; i++) {
                    stack.push(Integer.parseInt(input[i]));
                }
            } else if (command.equalsIgnoreCase("Pop")) {
                if(!stack.iterator().hasNext())
                    System.out.println("No elements");
                else
                    stack.pop();
            }

        }

    }
}
