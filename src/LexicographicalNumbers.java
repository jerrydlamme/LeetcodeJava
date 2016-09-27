import java.util.*;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new LinkedList<Integer>();
        
        dfs(list, n, 0);
        return list;
    }
    
    void dfs (List<Integer> list, int n, int cur) {
        if (cur != 0)
            list.add(cur);
        cur *= 10;
        int i = cur == 0 ? 1 : 0;
        for (; i < 10; i++) {
            if (cur + i <= n)
                dfs(list, n, cur + i);
        }
    }
}