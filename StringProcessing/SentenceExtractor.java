package SentenceExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine();
        String sentence = reader.readLine();

        Pattern pattern = Pattern.compile("(.+?)(!|\\\\.|\\\\?)+");
        Matcher matcher = pattern.matcher(sentence);

        while(matcher.find()){
            if(matcher.group(1).contains(" " + word + " ")){
                System.out.println(matcher.group().trim());
            }
        }
    }
}
