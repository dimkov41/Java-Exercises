package ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> list = new ArrayList<>();

        while (true) {
            String str = reader.readLine();

            if (str.equalsIgnoreCase("End"))
                break;

            String[] input = str.split("\\s+");

            String name = input[0];
            int age = Integer.parseInt(input[1]);
            String town = (input[2]);
            Person person = new Person(name, age, town);
            list.add(person);
        }

        int personToCompare = Integer.parseInt(reader.readLine()) - 1;
        Person person = list.get(personToCompare);

        int countEqualPeople = 1;

        for (int i = 0; i < list.size(); i++) {
            if (i != personToCompare) {
                if (person.compareTo(list.get(i)) == 0)
                    countEqualPeople++;
            }
        }

        if (countEqualPeople == 1)
            System.out.println("No matches");
        else
            System.out.printf("%d %d %d", countEqualPeople, list.size() - countEqualPeople, list.size());
    }
}
