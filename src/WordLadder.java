import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) return 1;
        
        int len = 1;
        
        Set<String> cur = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        cur.add(beginWord);
        end.add(endWord);
        
        while (!cur.isEmpty()) {
            len++;
            Set<String> nxt = new HashSet<String>();
            
            if (cur.size() > end.size()) {
                Set<String> tmp = cur;
                cur = end;
                end = tmp;
            }
            
            for (String str : cur) {
                char[] word = str.toCharArray();
                for (int i = 0; i < word.length; i++) {
                    char c = word[i];
                    for (char rep = 'a'; rep <= 'z'; rep++) {
                        word[i] = rep;
                        String s = new String(word);
                        
                        if (end.contains(s)) return len;
                        
                        if (wordList.contains(s) && !visited.contains(s)) {
                            nxt.add(s);
                            visited.add(s);
                        }
                    }
                    word[i] = c;
                }
            }
            
            cur = nxt;
        }
        
        return 0;
    }
}
