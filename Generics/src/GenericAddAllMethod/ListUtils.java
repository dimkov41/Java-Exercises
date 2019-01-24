

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListUtils<T extends Comparable<T>> {
    public static <T> void addAll(List<T> destination, List<? extends T> source){
        destination.addAll(source);
    }


    public static <T extends  Comparable<T>> T getMin(List<T> list){

        if(list.size() < 1)
            throw new IllegalArgumentException();

        T minElement = list.get(0);
        for (int i = 1; i < list.size();i++) {
            if(minElement.compareTo(list.get(i)) > 0 ){
                minElement = list.get(i);
            }
        }

        return minElement;
    }


    public static <T extends Comparable<T>> T getMax(List<T> list){

        if(list.size() < 1)
            throw new IllegalArgumentException();

        T maxElement = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(maxElement.compareTo(list.get(i)) < 0){
                maxElement = list.get(i);
            }
        }

        return maxElement;
    }

    public static List<Integer> getNullIndices(List<?> list){
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == null){
                integers.add(i);
            }
        }
        return integers;
    }

    public static <T> void flatten(List<T> destination, List<List<? extends T>> source){
        for (List<? extends T> ts : source) {
            destination.addAll(ts);
        }
    }


}
