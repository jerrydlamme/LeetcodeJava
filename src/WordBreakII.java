import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return new LinkedList<String>();
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
        
        if (!opt[opt.length-1]) return new LinkedList<String>();
        
        
        
        if (s == null || s.length() == 0) return new LinkedList<String>();
        
        List<String>[] lists = new List[s.length()];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<String>();
        }
        
        boolean first = wordDict.contains(s.substring(0,1));
        if (first) {
            lists[0].add(s.substring(0,1));
        }
        
        
        for (int i = 1; i < lists.length; i++) {
            if (wordDict.contains(s.substring(0, i+1))) {
                lists[i].add(s.substring(0, i+1));
            }
            for (int j = 1; j <=i; j++) {
                String sub = s.substring(j, i+1);
                if (!lists[j-1].isEmpty() && wordDict.contains(sub)) {
                    for (String ss : lists[j-1]) {
                        lists[i].add(ss + " " + sub);
                    }
                }
            }
        }
        
        return lists[lists.length-1];
    }
    
    public static void main(String[] args) {
    	WordBreakII ins = new WordBreakII();
//    	String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    	String s = "aaaaaaaaaaaaaaaaaaaaaaaaa";
    	Set<String> set = new HashSet<String>();
    	String[] arr = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
    	for (int i = 0; i < arr.length; i++) {
    		set.add(arr[i]);
    	}
    	
    	System.out.println(ins.wordBreak(s, set));
//    	ins.wordBreak(s, set);
    }
}
