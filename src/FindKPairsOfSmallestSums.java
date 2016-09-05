import java.util.*;

public class FindKPairsOfSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> heap = new PriorityQueue<Tuple>();
        List<int[]> list = new LinkedList<int[]>();
        
        if (nums1.length == 0 || nums2.length == 0) {
            return list;
        }
        
        for (int i = 0; i < nums2.length; i++) {
            heap.add(new Tuple(0, i, nums1[0] + nums2[i]));
        }
    
        Tuple tuple = null;
        
        for (int i = 0; i < k && !heap.isEmpty(); i++) {
            tuple = heap.poll();
            int[] pair = new int[2];
            pair[0] = nums1[tuple.i];
            pair[1] = nums2[tuple.j];
            list.add(pair);
            if (tuple.i < nums1.length-1) {
                heap.add(new Tuple(tuple.i+1, tuple.j, nums1[tuple.i+1]+nums2[tuple.j]));
            }
        }
        
        return list;
    }
    
    class Tuple implements Comparable<Tuple> {
        int i;
        int j;
        int sum;
        
        public Tuple (int i, int j, int sum){
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
        
        public int compareTo(Tuple other) {
            return this.sum - other.sum;
        }
    }
}
