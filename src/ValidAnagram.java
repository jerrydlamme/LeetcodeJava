
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] tbl = new int[256];
        
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        
        for(int i = 0; i < sarr.length; i++) {
            tbl[sarr[i]]++;
            tbl[tarr[i]]--;
        }
        
        for(int i = 0; i < tbl.length; i++) {
            if (tbl[i] != 0) return false;
        }
        
        return true;
    }
}
