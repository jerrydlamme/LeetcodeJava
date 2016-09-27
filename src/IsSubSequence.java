
public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) return false;
        
        int i = 0, j = 0;
        for (; i < s.length() && j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) i++;
        }
        
        if (i != s.length()) return false;
        return true;
    }
}
