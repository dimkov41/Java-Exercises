package CountSubstricOcc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();
        String word = scanner.nextLine().toLowerCase();

        Pattern pattern = Pattern.compile(word);

        Matcher matcher = pattern.matcher(text);

        int counter = 0;

        while(matcher.find()){
            counter++;
        }

        System.out.println(counter);
    }
}
