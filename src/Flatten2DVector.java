import java.util.*;

public class Flatten2DVector {
    
    List<Integer> list = new LinkedList<Integer>();
    int i = 0;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        for (List<Integer> sub : vec2d) {
            list.addAll(sub);
        }
    }

    public Integer next() {
        return list.get(i++);
    }

    public boolean hasNext() {
        return i < list.size();
    }
}
