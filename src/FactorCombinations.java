import java.util.*;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        
        List<List<Integer>> lists;
        lists = sub(n , 2);
        lists.remove(lists.size()-1);
    
        return lists;
    }
    
    List<List<Integer>> sub(int n, int low) {
    
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
    
        for (int i = low; i * i <= n; i++) {
            if (n % i == 0) {
                List<List<Integer>> sub = sub(n/i, i);
                for (List<Integer> list : sub) {
                    list.add(i);
                }
                lists.addAll(sub);
            }
        }
    
     
            List<Integer> list = new LinkedList<Integer>();
            list.add(n);
            lists.add(list);
    
    
        return lists;
    }
}
