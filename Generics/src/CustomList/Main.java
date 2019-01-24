package CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> list = new CustomList<>();

        while(true){
            String input = reader.readLine();
            if(input.equalsIgnoreCase("END"))
                break;

            String[] str = input.split("\\s+");

            if(str[0].equalsIgnoreCase("Add")){
                String element = str[1];
                list.add(element);
            }
            else if(str[0].equalsIgnoreCase("Remove")){
                int index = Integer.parseInt(str[1]);
                list.remove(index);
            }
            else if(str[0].equalsIgnoreCase("Contains")){
                String element = str[1];
                System.out.println(list.contains(element));
            }
            else if(str[0].equalsIgnoreCase("Swap")){
                int firstIndex = Integer.parseInt(str[1]);
                int secondIndex = Integer.parseInt(str[2]);
                list.swap(firstIndex,secondIndex);
            }
            else if(str[0].equalsIgnoreCase("Greater")){
                String element = str[1];
                System.out.println(list.countGreaterThan(element));
            }
            else if(str[0].equalsIgnoreCase("Max")){
                System.out.println(list.getMax());
            }
            else if(str[0].equalsIgnoreCase("Min")){
                System.out.println(list.getMin());
            }
            else if(str[0].equalsIgnoreCase("Print")){
                System.out.println(list.print());
            }
        }
    }
}
