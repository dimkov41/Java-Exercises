

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers,5,6,2,null,-1,null,-11);

        System.out.println(ListUtils.getNullIndices(integers));
    }
}
