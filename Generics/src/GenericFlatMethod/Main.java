

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1,3,2);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles,1.2,3.2);

        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged,integers,doubles);

        List<Number> numbers = new ArrayList<>();
        ListUtils.flatten(numbers,jagged);
        System.out.println();
    }
}
