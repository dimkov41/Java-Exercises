package UserLogs;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String,Integer>> usersAndIp = new TreeMap<>();

        while(true){
            String[] input = scanner.nextLine().split("\\s+");

            if(input[0].equals("end"))
                break;

            String ip = equalSplit(input[0]);
            String username = equalSplit(input[2]);

            if(!usersAndIp.containsKey(username)){
                Map<String,Integer> map = new LinkedHashMap<>();
                map.put(ip,1);
                usersAndIp.put(username,map);
            }
            else{
                Map<String,Integer> map = usersAndIp.get(username);
                if(map.containsKey(ip)){
                    int ipCount = map.get(ip);
                    map.put(ip,ipCount + 1);
                }
                else{
                    map.put(ip,1);
                }
            }

        }

        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : usersAndIp.entrySet()) {

            System.out.printf("%s:%n",stringMapEntry.getKey());

            if(stringMapEntry.getValue().size() > 1){

                int counter = stringMapEntry.getValue().size() - 1;

                for (Map.Entry<String, Integer> m : stringMapEntry.getValue().entrySet()) {
                    if(counter == 0){
                        System.out.printf("%s => %d.%n", m.getKey(), m.getValue());
                    }
                    else{
                        System.out.printf("%s => %d, ", m.getKey(), m.getValue());
                    }
                    counter--;
                }
            }

            else {

                for (Map.Entry<String, Integer> m : stringMapEntry.getValue().entrySet()) {
                    System.out.printf("%s => %d.%n", m.getKey(), m.getValue());
                }

            }
        }
    }

    public static String equalSplit(String input){
        String[] str = input.split("=");
        return str[1];
    }
}
