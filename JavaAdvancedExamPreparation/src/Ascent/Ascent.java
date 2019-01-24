package Ascent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "([_,])([a-zA-Z]+)([0-9])";

        Map<String, String> decodedWords = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile(regex);

        while (true){
            String line = reader.readLine();

            if("Ascend".equals(line))
                break;

            for (Map.Entry<String, String> decodedWord : decodedWords.entrySet()) {
                line = line.replaceAll(decodedWord.getKey(),decodedWord.getValue());
            }

            Matcher matcher = pattern.matcher(line);

            while (matcher.find()){
                String decoded = decode(matcher.group(1),
                        matcher.group(2),
                        Integer.parseInt(matcher.group(3)));

                decodedWords.putIfAbsent(matcher.group(0),decoded);

                line = line.replaceAll(matcher.group(0),decoded);
            }
            System.out.println(line);
        }
    }

    private static String decode(String sign, String encodedString, int digit) {
        String decoded = "";

        for (int i = 0; i < encodedString.length(); i++) {
            char currentLetter = '\0';
            if(sign.equals(",")){
                currentLetter = (char)(encodedString.charAt(i) + (char) digit);
            }else {
                currentLetter = (char)(encodedString.charAt(i) - (char) digit);
            }
            decoded += currentLetter;
        }

        return decoded;
    }
}
