import java.util.*;
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new LinkedList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                count++;
                map.put(nums[i], count);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        Competer comparator = new Competer();
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<Map.Entry<Integer, Integer>>(map.size(), comparator);
        heap.addAll(map.entrySet());

        for (int i = 0; i < k; i++) {
        	Map.Entry<Integer, Integer> entry = heap.poll();
        	list.add(entry.getKey());
        }
        
        return list;
    }
}

class Competer implements Comparator<Map.Entry<Integer, Integer>> {
    public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
    	return -(entry1.getValue() - entry2.getValue());
    }
}