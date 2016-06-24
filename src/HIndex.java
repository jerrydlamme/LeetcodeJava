import java.util.*;

public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        
        int h = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > h) {
                if (queue.size() == 0) {
                    queue.add(citations[i]);
                    h++;
                    continue;
                } 
                
                int head = queue.peek();
                
                if (head == h) {
                    queue.poll();
                    queue.add(citations[i]);
                } else {
                    queue.add(citations[i]);
                    h++;
                }
            }
        }
        
        return h;
    }
}
