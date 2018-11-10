package UnicodeCharactees;

import java.nio.charset.Charset;
import java.util.Scanner;

public class Uni {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();

        for (int i = 0; i < s.length(); i++) {
            System.out.printf("\\u" + Integer.toHexString(s.charAt(i) | 0x10000).substring(1));
        }
    }
}
