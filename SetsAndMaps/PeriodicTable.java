package PeriodicTable;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lenght = Integer.parseInt(scan.nextLine());

        Set<String> set = new TreeSet<>();

        for (int i = 0; i < lenght; i++) {
            String[] input = scan.nextLine().split("\\s+");

            for (int j = 0; j < input.length; j++) {
                set.add(input[j]);
            }
        }

        set.forEach(s -> System.out.printf("%s ",s));
    }
}
