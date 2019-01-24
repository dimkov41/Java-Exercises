package ListyIterator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] string = scanner.nextLine().split(" ");
        String[] elements = new String[string.length - 1];
        for (int i = 1; i <= elements.length; i++) {
            elements[i - 1] = string[i];
        }

        ListyIterator<String> listyIterator = new ListyIterator<>(elements);

        while (true) {
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("END"))
                break;

            String[] input = str.split("\\s+");

            if (input[0].equalsIgnoreCase("Move")) {
                System.out.println(listyIterator.move());
            } else if (input[0].equalsIgnoreCase("Print")) {
                listyIterator.print();
            } else if (input[0].equalsIgnoreCase("HasNext")) {
                System.out.println(listyIterator.iterator().hasNext());
            } else if (input[0].equalsIgnoreCase("PrintALL")) {
                System.out.println(String.join(" ",listyIterator));
            }
        }

    }
}
