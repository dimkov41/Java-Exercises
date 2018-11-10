package MagicExchangeableWords;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        char[] firstWordAsArr = input[0].toCharArray();
        char[] secondWordAsArr = input[1].toCharArray();

        HashSet<Character> firstWord = new LinkedHashSet<>();
        HashSet<Character> secondWord = new LinkedHashSet<>();

        for (char c : firstWordAsArr) {
            firstWord.add(c);
        }

        for (char c : secondWordAsArr) {
            secondWord.add(c);
        }

        System.out.println((firstWord.size() == secondWord.size()) ? "true" : "false");
    }
}
