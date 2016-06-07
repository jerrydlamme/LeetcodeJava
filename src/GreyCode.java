import java.util.*;

public class GreyCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<Integer>();
        
        if (n < 0) return list;
        
        if (n == 0) {
            list.add(0);
            return list;
        }
        
        List<Integer> pre = grayCode(n - 1);
        
        list.addAll(pre);
        
        for (int i = pre.size()-1; i >= 0; i--) {
            list.add(pre.get(i) + (int)Math.pow(2, n-1));
        }
        
        return list;
    }
}
