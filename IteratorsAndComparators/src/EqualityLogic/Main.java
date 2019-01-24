package EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> treeSet = new TreeSet<>();
        Set<Person> hashSet = new HashSet<>();

        int countOfRows = Integer.parseInt(reader.readLine());

        for (int i = 0; i < countOfRows; i++) {
            String[] input = reader.readLine().split("\\s+");

            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name,age);

            treeSet.add(person);
            hashSet.add(person);
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
