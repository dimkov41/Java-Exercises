package UpperStrings;

        import java.util.Arrays;
        import java.util.Scanner;

public class UpperStings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Arrays.stream(input).map(String::toUpperCase).forEach(i -> System.out.print(i + " "));
    }
}
