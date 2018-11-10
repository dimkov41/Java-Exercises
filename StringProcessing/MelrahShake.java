package MelrahShake;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MelrahShake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String string = scan.nextLine();
        String pattern = scan.nextLine();

        while(true){
            int firstIndex = string.indexOf(pattern);
            int secondIndex = string.lastIndexOf(pattern);
            if(firstIndex > -1 && secondIndex > -1 && pattern.length() > 0){
                StringBuilder sb = new StringBuilder(string);
                sb.delete(firstIndex,firstIndex + pattern.length());
                sb.delete(secondIndex - pattern.length(),pattern.length() + (secondIndex - pattern.length()));

                string = sb.toString();

                System.out.println("Shaked it.");

                int indexToRemove = pattern.length()/2;
                if(pattern.length() > 0){
                    StringBuilder builder = new StringBuilder(pattern);
                    builder.deleteCharAt(indexToRemove);
                    pattern = builder.toString();
                }
            }
            else{
                System.out.println("No shake.");
                System.out.println(string);
                break;
            }
        }



    }
}
