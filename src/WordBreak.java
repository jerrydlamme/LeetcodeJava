import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        boolean[] opt = new boolean[s.length()];
        opt[0] = wordDict.contains(s.substring(0,1));
        
        for (int i = 1; i < opt.length; i++) {
            if (wordDict.contains(s.substring(0, i+1))) {
                opt[i] = true;
                continue;
            } else {
                for (int j = 1; j <=i; j++) {
                    if (opt[j-1] && wordDict.contains(s.substring(j, i+1))) {
                        opt[i] = true;
                        continue;
                    }
                }
            }
        }
        
        return opt[opt.length-1];
    }
}
