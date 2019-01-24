package StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> nameComp = new TreeSet<>(new NameComparator());
        TreeSet<Person> ageComp = new TreeSet<>(new AgeComparator());

        int countOfLines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < countOfLines; i++) {
            String[] input = reader.readLine().split("\\s+");

            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name,age);
            nameComp.add(person);
            ageComp.add(person);
        }

        for (Person person : nameComp) {
            System.out.println(person);
        }

        for (Person person : ageComp) {
            System.out.println(person);
        }




    }
}
