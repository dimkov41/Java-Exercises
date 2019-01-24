package CustomStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CustomStack<T> implements Iterable<T>{
    private final int INITIAL_CAPACITY = 1;

    private Object[] stack;
    private int lastIndex;

    public CustomStack() {
        stack = new Object[INITIAL_CAPACITY];
        lastIndex = -1;
    }

    public void push(T element){
        lastIndex++;
        if(this.lastIndex == this.stack.length) {
            //resizing array
            stack = growArray(stack);
        }

        stack[lastIndex] = element;
    }

    public Object[] growArray(Object[] stack){
        Object[] oldItems = stack;
        stack = new Object[oldItems.length * 2];
        for (int i = 0; i < oldItems.length; i++) {
            stack[i] = oldItems[i];
        }
        return stack;
    }

    public T pop(){
        T element = (T) stack[lastIndex];
        //removing last element
        List<Object> list = new ArrayList<>(Arrays.asList(stack));
        list.remove(list.get(lastIndex));
        stack = list.toArray();

        lastIndex--;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator<>();
    }

    private final class StackIterator<T> implements Iterator<T>{
        private int a = stack.length;
        private int counter = stack.length - 1;
        @Override
        public boolean hasNext() {
            return counter >= 0;
        }

        @Override
        public T next() {
            return (T) stack[counter--];
        }
    }
}
