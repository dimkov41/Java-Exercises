package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private T t;

    public Box(T t) {
        this.t = t;
    }

    private Class<T> checkClass(){
        Class<T> o = (Class<T>) t.getClass();
        return o;
    }

    @Override
    public String toString() {
        return String.format("%s: ", checkClass().getName()) + t;
    }

    public static <T> void swap(List<T> list,int firstIndex, int secondIndex){
        T firstItem = null;
        T secondItem = null;

        for (int i = 0; i < list.size(); i++) {
            if(i == firstIndex)
                firstItem = list.get(i);
            else if(i == secondIndex)
                secondItem = list.get(i);
        }

        if(firstItem != null && secondItem != null){
            list.set(firstIndex,secondItem);
            list.set(secondIndex,firstItem);
        }
    }

    public static <T> int countDoubles(List<? extends Comparable<T>> list, T o2){
        int counter = 0;

        for (Comparable<T> o1 : list) {
            if(o1.compareTo(o2) > 0)
                counter++;
        }

        return counter;
    }

    //{class full name: value}
}
