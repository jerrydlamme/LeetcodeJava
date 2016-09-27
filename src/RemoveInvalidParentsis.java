import java.util.*;

public class RemoveInvalidParentsis {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new LinkedList<String>();
        remove(s, 0, 0, list, new char[]{'(', ')'});
        return list;
    }
    
    void remove(String s, int last_i, int last_j, List<String> list, char[] pair) {
        int count = 0;
        for (int i = last_i; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pair[0]) count++;
            if (c == pair[1]) count--;
            if (count >= 0) continue;
            
            for (int j = last_j; j <=i; j++) {
                if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j-1) != pair[1])) {
                    remove(s.substring(0, j) + s.substring(j+1, s.length()), i, j, list, pair);
                }
            }
            return;
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        
        if (pair[0] == '(') {
            remove(reversed, 0, 0, list, new char[]{')', '('});        
        } else {
            list.add(reversed);
        }
    }
}
