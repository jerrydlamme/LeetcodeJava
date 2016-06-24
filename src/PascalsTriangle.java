import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        
        if (numRows == 0) return lists;
        
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        lists.add(list);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> nxt = new LinkedList<Integer>();
            nxt.add(1);
            for (int j = 0; j < list.size()-1; j++) {
                nxt.add(list.get(j) + list.get(j+1));
            }
            nxt.add(1);
            lists.add(nxt);
            list = nxt;
        }
        
        return lists;
    }
}
