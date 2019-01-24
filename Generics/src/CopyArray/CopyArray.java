import java.util.Collections;
import java.util.List;

public class CopyArray {
    public static <T> void copy(List<? super T> destination, List<? extends T> src){
        Collections.copy(destination,src);
    }
}
