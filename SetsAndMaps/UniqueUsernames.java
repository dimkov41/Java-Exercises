package UniqueUsernames;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sequence = Integer.parseInt(scan.nextLine());

        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < sequence; i++) {
            String input = scan.nextLine();
            usernames.add(input);
        }

        usernames.forEach(u -> System.out.println(u));
    }
}
