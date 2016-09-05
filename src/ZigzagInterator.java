import java.util.*;
public class ZigzagInterator {
    List<Integer> list;
    int index;

    public ZigzagInterator(List<Integer> v1, List<Integer> v2) {
        index = 0;
        if (v1 == null || v1.size() == 0) {
            list = v2;
            return;
        }
        if (v2 == null || v2.size() == 0) {
            list = v1;
            return;
        }
        boolean first = true;
        int i = 0;
        list = new LinkedList<Integer>();
        while (i < v1.size() || i < v2.size()) {
            if (first) {
                if (i < v1.size()) {
                    list.add(v1.get(i));
                }
                first = !first;
            } else {
                if (i < v2.size()) {
                    list.add(v2.get(i));
                }
                first = !first;
                i++;
            }
        } 
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }
}
