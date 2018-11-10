package SetsOfElements;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        Set<Integer> finalSet = new LinkedHashSet<>();

        for (int i = 0; i < input[0]; i++) {
            int num = Integer.parseInt(scan.nextLine());
            firstSet.add(num);
        }

        for (int i = 0; i < input[1]; i++) {
            int num = Integer.parseInt(scan.nextLine());
            secondSet.add(num);
        }

        for (Integer currentFirst : firstSet) {
            for (Integer currentSecond : secondSet) {
                if(currentFirst == currentSecond){
                    finalSet.add(currentFirst);
                }
            }
        }

        finalSet.forEach(f -> System.out.printf("%d ",f));
    }
}
