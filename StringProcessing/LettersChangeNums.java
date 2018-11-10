package LettersChangeNums;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LettersChangeNums {
    private final static String LOWER_CASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final static String UPPER_CASE_ALPHABET = LOWER_CASE_ALPHABET.toUpperCase();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("[\\s]+");

        List<Double> sums = new ArrayList<>(input.length);


        for (String currentSeq : input) {
            String firstLetter = Character.toString(currentSeq.charAt(0));
            String secondLetter = Character.toString(currentSeq.charAt(currentSeq.length()-1));

            double num = Double.parseDouble(currentSeq.substring(1,currentSeq.length() - 1));

            //is UPPERCASE
            if(firstLetter.equals(firstLetter.toUpperCase())){
                int letterPos = UPPER_CASE_ALPHABET.indexOf(firstLetter) + 1;
                num /= letterPos;
            }
            //is lowercase
            else if(firstLetter.equals(firstLetter.toLowerCase())){
                int letterPos = LOWER_CASE_ALPHABET.indexOf(firstLetter) + 1;
                num *= letterPos;
            }

            //second is UPPERCASE
            if(secondLetter.equals(secondLetter.toUpperCase())){
                int letterPos = UPPER_CASE_ALPHABET.indexOf(secondLetter) + 1;
                num -= letterPos;
            }
            else if(secondLetter.equals(secondLetter.toLowerCase())){
                int letterPos = LOWER_CASE_ALPHABET.indexOf(secondLetter) + 1;
                num += letterPos;
            }

            sums.add(num);
        }

        double totalSum = 0;

        for (Double s : sums) {
            totalSum += s;
        }

        System.out.printf("%.2f",totalSum);

    }
}
