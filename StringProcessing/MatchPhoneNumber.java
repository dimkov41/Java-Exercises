package MatchPhoneNumber;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true){
            String input = scan.nextLine();
            if(input.equals("end"))
                break;
            if(Pattern.matches("^\\+359+([ -])[0-9]([ -])\\d{3}\\1\\d{4}$",input)){
                System.out.println(input);
            }
        }
    }
}
