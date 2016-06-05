import java.util.*;
public class NQueensII {
    public int totalNQueens(int n) {
        List<List<String>> lists = new LinkedList<List<String>>();
        
        int[] mask = new int[n];
        
        pass(lists, mask, 0, n);
        
        return lists.size();
    }
    
    public void pass(List<List<String>> lists, int[] mask, int index, int n) {
        for (int i = 0; i < n; i++) {
            if (canPlace(mask, index, i, n)) {
                mask[index] = i;
                if (index == n-1) {
                    addList(lists, mask, n);
                } else {
                    pass(lists, mask, index + 1, n);
                }
            }
        }
        
    }
    
    public boolean canPlace(int[] mask, int index, int pos, int n) {
        for (int i = 0; i < index; i++) {
            if (mask[i] == pos || Math.abs(pos - mask[i]) == Math.abs(index - i))
                return false;
        }
        return true;
    }
    
    public void addList(List<List<String>> lists, int[] mask, int n) {
        List<String> list = new LinkedList<String>();
        
        for (int i = 0; i < n; i++) {
            StringBuffer buf = new StringBuffer();
            for (int j = 0; j < n; j++) {
                if (mask[i] == j) {
                    buf.append('Q');
                } else {
                    buf.append('.');
                }
            }
            list.add(buf.toString());
        }
        
        lists.add(list);
    }
}
