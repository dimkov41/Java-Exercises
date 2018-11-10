package MinerTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rowCounter = 1;
        String resource = null;

        Map<String,Integer> map = new HashMap<>();

        while(true){
            String input = scan.nextLine();
            if(input.equals("stop"))
                break;

            //if odd
            if(rowCounter % 2 == 1){
                boolean isAvailable = map.containsKey(input);
                if(!isAvailable){
                    map.put(input,0);
                }
            }
            //if even
            else{
                    int currentQuantity = map.get(resource);
                    int totalQuantity = currentQuantity + Integer.parseInt(input);

                    map.put(resource,totalQuantity);
            }

            rowCounter++;
            resource = input;
        }

        for (Map.Entry<String, Integer> s : map.entrySet()) {
            System.out.printf("%s -> %d%n",s.getKey(),s.getValue());
        }
    }
}
