package PhoneBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,String> map = new HashMap<>();

        outerloop:
        while(true){
            String input = scan.nextLine();
            if(input.equals("search")){
                while(true){
                    String str = scan.nextLine();
                    if(str.equals("stop")){
                        break outerloop;
                    }
                    boolean isAvailable = map.containsKey(str);
                    if(isAvailable){
                        System.out.printf("%s -> %s%n",str,map.get(str));
                    }
                    else{
                        System.out.printf("Contact %s does not exist.%n",str);
                    }

                }
            }
            else if(input.equals("stop")){
                break;
            }
            else{
                String[] peopleAndPhoneNumber = input.split("-");
                String name = peopleAndPhoneNumber[0];
                String phoneNumber = peopleAndPhoneNumber[1];

                map.put(name,phoneNumber);
            }
        }
    }
}
