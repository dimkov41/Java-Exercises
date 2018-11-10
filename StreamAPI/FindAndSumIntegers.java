package FindAndSumIntegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Optional<Integer> input = Arrays.stream(reader.readLine().split(" "))
                .filter(x -> {
                    try{
                        Integer.parseInt(x);
                        return true;
                    }catch (Exception e){
                        return false;
                    }
                }).map(Integer::parseInt).reduce((x,y)-> x + y);
        System.out.println(input.isPresent() ? input.get() : "No match");
    }
}
