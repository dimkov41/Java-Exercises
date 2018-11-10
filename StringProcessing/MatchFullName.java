package MatchFullName;

        import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true){
            String input = scan.nextLine();
            if(input.equals("end"))
                break;
            if(Pattern.matches("^[A-Z][a-z]+ [A-Z][a-z]+$",input)){
                System.out.println(input);
            }
        }
    }
}
