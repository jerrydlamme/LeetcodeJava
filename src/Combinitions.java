import java.util.*;
public class Combinitions {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        
        if (k > n) return lists;
        
        int[] roll = new int[k];
        
        forward(roll, 0, n, lists);
        
        return lists;
    }
    
    public void forward(int[] roll, int ind, int n, List<List<Integer>> lists) {
        int base = ind == 0 ? 1 : roll[ind-1] + 1;
        int len = roll.length;
        for (int i = base; i <= n; i++) {
            roll[ind] = i;
            if (ind == len-1) {
                List<Integer> list = new LinkedList<Integer>();
                for(int j = 0; j < len; j++) {
                    list.add(roll[j]);
                }
                lists.add(list);
            } else {
                forward(roll, ind+1, n, lists);
            }
        }
    }
}
