import java.util.*;

public class WordPatternII {
    
    Map<Character, String> map = new HashMap<Character, String>();
    Set<String> set = new HashSet<String>();
        
    public boolean wordPatternMatch(String pattern, String str) {
        if (str.length() < pattern.length()) return false;
        if (str.length() == 0 && pattern.length() == 0) return true;
        if (pattern.length() == 0) return false;
        
        return rec(pattern, str, 0, 0);
    }
    
    boolean rec(String pattern, String str, int index, int pos) {
        char c = pattern.charAt(index);
        if (index == pattern.length()-1) {
            if (map.containsKey(c)) {
                return map.get(c).equals(str.substring(pos));   
            } else {
                if (pos >= str.length()) return false;
                return !set.contains(str.substring(pos));
            }
        } else {
            if (!map.containsKey(c)) {
                for (int i = pos + 1; i <= str.length(); i++) {
                    String substr = str.substring(pos, i);
                    if (set.contains(substr)) continue;
                    
                    map.put(c, substr);
                    set.add(substr);
                    if (rec(pattern, str, index+1, pos+substr.length())) return true;
                    set.remove(substr);
                    map.remove(c);
                }
            } else {
                String substr = map.get(c);
                if (str.length() - pos < substr.length() + pattern.length() - index - 1) return false;
                if (!substr.equals(str.substring(pos, pos + substr.length()))) {
                    return false;
                } else {
                    return rec(pattern, str, index + 1, pos + substr.length());
                }
            }
        }
        
        return false;
    }
}
