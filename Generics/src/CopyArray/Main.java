import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(){{add(3);}};
        List<Number> numbers = new ArrayList<>(){{add(3.2);add(43);}};
        System.out.println();

        CopyArray.copy(numbers,integers);
        System.out.println();
    }
}
