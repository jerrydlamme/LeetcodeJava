import java.util.*;

public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> list = new LinkedList<String>();
        if (s.length() == 0) return list;
        if (s.length() == 1) {
            list.add(s);
            return list;
        }
        
        int count = 0;
        int[] mask = new int[256];
        String mid = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (++mask[c] % 2 == 0) {
                count--;
            } else {
                count++;
            }
        }
        
        if (count > 1) return list;
        
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] % 2 == 1) mid = "" + (char)i;
            mask[i] /= 2;
        }
        
        char[] opt = new char[s.length()/2];
        rec(opt, 0, mask, list, mid);

        return list;
    }
    
    void rec(char[] opt, int index, int[] mask, List<String> list, String mid) {
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] > 0) {
                mask[i]--;
                opt[index] = (char)i;
                if (index == opt.length-1) {
                    String str = new String(opt);
                    String rev = new StringBuilder(str).reverse().toString();
                    list.add(str + mid + rev);
                } else {
                    rec(opt, index+1, mask, list, mid);
                }
                mask[i]++;
            } 
        }
    }
}
