package EqualityLogic;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name,this.age);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Person;
    }

    @Override
    public int compareTo(Person o) {
        if(this.name.compareTo(o.name) != 0)
            return this.name.compareTo(o.name);
        //it's different
        return Integer.compare(this.age,o.age);
    }
}
