package FixEmails;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> map = new HashMap<>();

        int rowCounter = 1;
        String person = null;

        while(true){
            String input = scanner.nextLine();
            if("stop".equals(input))
                break;

            if(rowCounter %2 == 1){
                map.put(input,null);
            }
            else{
                if(input.endsWith(".us") ||
                        input.endsWith(".uk") ||
                        input.endsWith(".com")){
                    boolean isAvailable = map.containsKey(person);
                    if(isAvailable){
                        map.remove(person);
                    }
                }
                else{
                    map.put(person,input);
                }
            }

            rowCounter++;
            person = input;
        }

        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.printf("%s -> %s%n",s.getKey(),s.getValue());
        }
    }
}
