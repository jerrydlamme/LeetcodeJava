import java.util.*;

public class TestIIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<Map.Entry<Integer, Integer>>(k, new Comper());
        List<Integer> list = new LinkedList<Integer>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                map.put(i, count+1);
            } else {
                map.put(i, 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (heap.size() < k) {
                heap.offer(entry);
            } else {
                if (entry.getValue() > heap.peek().getValue()) {
                    heap.poll();
                    heap.offer(entry);
                }
            }
        }
        
        while (!heap.isEmpty()) {
            list.add(heap.poll().getKey());
        }
        
        return list;
    }
    
    public class Comper implements Comparator<Map.Entry<Integer, Integer>> {
        public int compare (Map.Entry<Integer, Integer> ent1, Map.Entry<Integer, Integer> ent2) {
            return ent1.getValue() - ent2.getValue();
        }
    }

}
