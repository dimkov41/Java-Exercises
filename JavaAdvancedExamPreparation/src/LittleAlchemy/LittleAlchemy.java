package LittleAlchemy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LittleAlchemy {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Deque<Integer> stones = new ArrayDeque<>();
    private static int amountOfGold = 0;
    public static void main(String[] args) throws IOException {

            int[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            //fill stack
            for (int i = 0; i < input.length; i++) {
                stones.offer(input[i]);
            }
        while(true){
            String[] inputStr = reader.readLine().split("\\s+");

            if(inputStr[0].equalsIgnoreCase("Revision"))
                break;

            if(inputStr[0].equalsIgnoreCase("Apply")){

                int countOfElements = Integer.parseInt(inputStr[2]);

                if(stones.size() != 0) {
                    for (int i = 0; i < countOfElements; i++) {
                        int popedNum = stones.poll();
                        popedNum -= 1;

                        if (popedNum != 0) {
                            stones.offer(popedNum);
                        } else if(popedNum == 0) {
                            amountOfGold++;
                        }

                        if(stones.size() == 0){
                            break;
                        }
                    }
                }
            }
            else if(inputStr[0].equalsIgnoreCase("Air") && amountOfGold != 0){
                int num = Integer.parseInt(inputStr[2]);

                stones.offer(num);
                amountOfGold--;

            }
        }

        for (Integer currentStore : stones) {
            System.out.printf("%d ",currentStore);
        }
        System.out.println();
        System.out.println(amountOfGold );
    }
}
