package CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    List<T> list = new ArrayList<>();

    public void add(T element){
        this.list.add(element);
    }

    public T remove(int index){
        return this.list.remove(index);
    }

    public boolean contains(T element){
        return this.list.contains(element);
    }

    @SuppressWarnings("Duplicates")
    public void swap(int firstIndex, int secondIndex){
        T firstItem = null;
        T secondItem = null;

        for (int i = 0; i < list.size(); i++) {
            if(i == firstIndex)
                firstItem = this.list.get(i);
            else if(i == secondIndex)
                secondItem = this.list.get(i);
        }

        if(firstItem != null && secondItem != null){
            list.set(firstIndex,secondItem);
            list.set(secondIndex,firstItem);
        }
    }

    public int countGreaterThan(T o2){
        int counter = 0;
        for (Comparable<T> o1 : this.list) {
            if(o1.compareTo(o2) > 0)
                counter++;
        }

        return counter;
    }

    public T getMax(){
        int maxPosition = 0;
        if(this.list.size() > 0) {
            T firstElement = this.list.get(0);
            for (int i = 1; i < this.list.size(); i++) {
                if (firstElement.compareTo(this.list.get(i)) < 0) {
                    maxPosition = i;
                }
            }
        }

        return this.list.get(maxPosition);
    }

    public T getMin(){
        int minPosition = 0;
        if(this.list.size() > 0) {
            T firstElement = this.list.get(0);
            for (int i = 1; i < this.list.size(); i++) {
                if (firstElement.compareTo(this.list.get(i)) > 0) {
                    minPosition = i;
                }
            }
        }

        return this.list.get(minPosition);
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if(i == list.size() - 1){
                stringBuilder.append(this.list.get(i));
            }else
                stringBuilder.append(this.list.get(i)).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

}
