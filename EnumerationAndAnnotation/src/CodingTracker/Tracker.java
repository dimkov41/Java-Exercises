package CodingTracker;

import java.lang.reflect.Method;
import java.util.*;

public class Tracker {

    @Author(name = "Pesho")
    static void printMethodsByAuthor(Class<?> clazz){
        Map<String,List<String>> map = new HashMap<>();

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            String author = method.getAnnotation(Author.class).name();

            if(author != null){
                map.putIfAbsent(author,new ArrayList<>());
                map.get(author).add(method.getName() + "()");
            }
        }

        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            System.out.printf("%s: ",stringListEntry.getKey());
            System.out.printf(String.join(", ",stringListEntry.getValue()));
        }
    }


    @Author(name = "Pesho")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
