package TextFilter;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().replaceAll("\\s+","").split(",");

        String text = scanner.nextLine();

        for (int i = 0; i < bannedWords.length; i++) {
            text = text.replaceAll(bannedWords[i],generateStars(bannedWords[i].length()));
        }

        System.out.println(text);
    }

    public static String generateStars(int lenght){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            sb.append("*");
        }

        return sb.toString();

    }
}
