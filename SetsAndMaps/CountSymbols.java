package CountSymbols;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Map<Character,Integer> countSymbols = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            if(countSymbols.containsKey(input.charAt(i))){
                int currentCount = countSymbols.get(input.charAt(i));
                countSymbols.put(input.charAt(i),currentCount + 1);
            }
            else{
                countSymbols.put(input.charAt(i),1);
            }
        }

        for (Map.Entry<Character, Integer> c : countSymbols.entrySet()) {
            System.out.printf("%s: %d time/s%n",c.getKey(),c.getValue());
        }
    }
}
