package ListyIterator;

import java.lang.reflect.Array;
import java.util.*;

public final class ListyIterator<T> implements Iterable<T> {
    private Object[] list;
    private int counter = 0;
    private int count = 0;

    public ListyIterator(T... elements) {
        list = new Object[elements.length];
        for (int i = 0; i < elements.length; i++) {
            list[i] = elements[i];
        }
    }

    public boolean move(){
        if(this.counter < this.list.length) {
            counter++;
            return true;
        }
        return false;
    }

    public void print(){
        if(list.length < 1) {
            System.out.println("Invalid Operation!");
            return;
        }
        System.out.println(list[counter]);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            @Override
            public boolean hasNext() {
                return count < list.length;
            }

            @Override
            public T next() {
                return (T) list[count++];
            }
        };
    }
}
