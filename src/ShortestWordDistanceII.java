import java.util.*;
public class ShortestWordDistanceII {
    Map<String, List<Integer>> map;

    public ShortestWordDistanceII(String[] words) {
        this.map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new LinkedList<Integer>();
                list.add(i);
                map.put(words[i],  list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int last = 0; 
        int dis = Integer.MAX_VALUE;
        int i = 0, j = 0;
        boolean inOne;
        if (list1.get(0) < list2.get(0)) {
            inOne = true;
        } else {
            inOne = false;
        }
        
        while (i < list1.size() || j < list2.size()) {
            if (j >= list2.size() || (i < list1.size() && list1.get(i) < list2.get(j))) {
                if (inOne) {
                    last = list1.get(i);   
                } else {
                    dis = Math.min(dis, list1.get(i) - last);
                    inOne = !inOne;    
                    last = list1.get(i);
                }
                i++;
            } else {
                if (!inOne) {
                    last = list2.get(j);
                } else {
                    dis = Math.min(dis, list2.get(j) - last);
                    inOne = !inOne;
                    last = list2.get(j);
                }
                j++;
            }
        }
        
        return dis;
    }
}
