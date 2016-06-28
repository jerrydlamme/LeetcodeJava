import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) return false;
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        
        Map<Character, String> p2w = new HashMap<Character, String>();
        Map<String, Character> w2p = new HashMap<String, Character>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (p2w.containsKey(c)) {
                if (!p2w.get(c).equals(words[i])) return false;
            } else {
                if (w2p.containsKey(words[i])) return false;
                
                p2w.put(c, words[i]);
                w2p.put(words[i], c);
            }
        }
        
        return true;
    }
}
