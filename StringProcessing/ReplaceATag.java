package ReplaceATag;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();

        List<String> matches = new LinkedList<>();

        while(true){
            String input = scan.nextLine();
            if(input.equals("END")){
                break;
            }
            builder.append(input).append(System.lineSeparator());
        }

        Pattern pattern = Pattern.compile("\\<a ([\\w=\":\\/.\\r\\n]+)>([\\w\\d\\r\\n]+)<\\/a>");
        Matcher matcher = pattern.matcher(builder.toString());

        String str = builder.toString();
        while(matcher.find()){
            str = str.replace(matcher.group(),"[URL " + matcher.group(1) + "]" + matcher.group(2) + "[/URL]");
        }

        System.out.println(str);
    }
}
