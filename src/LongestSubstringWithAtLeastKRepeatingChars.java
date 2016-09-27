import java.util.*;

public class LongestSubstringWithAtLeastKRepeatingChars {
    public int longestSubstring(String s, int k) {
        if (k <= 1) return s.length();
        if (s.length() < k) return 0;
        
        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> list = new LinkedList<Integer>();
                list.add(i);
                map.put(c, list);
            }
        }
        
        int count = 0;
        int[] arr = new int[s.length()];
        
        for (Character c : map.keySet()) {
            List<Integer> list = map.get(c);
            if (list.size() < k) {
                for (Integer j : list) {
                    arr[count++] = j;
                }
            }
        }
        
        if (count == 0) return s.length();
        
        Arrays.sort(arr, 0, count);
        
        if (arr[count-1] < s.length()-1) {
        	arr[count++] = s.length();
        } 
        
        int start = 0, end = 0;
        int max = 0;
        
        for (int i = 0; i < count; i++) {
            end = arr[i];
            System.out.println("start = " + start + " , end = " + end);
            if (end - start >= k) {
                max = Math.max(max, longestSubstring(s.substring(start, end), k));
            }
            
            start = end+1;
        }
        
        return max;
    }
    
    
    
    public static void main(String[] args) {
    	LongestSubstringWithAtLeastKRepeatingChars ins = new LongestSubstringWithAtLeastKRepeatingChars();
    	System.out.println(ins.longestSubstring("bbaaacbd", 3));
    }
}

