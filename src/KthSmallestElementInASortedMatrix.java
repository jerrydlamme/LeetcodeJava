import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> heap = new PriorityQueue<Tuple>();
        
        for (int i = 0; i < n; i++) {
            heap.add(new Tuple(0, i, matrix[0][i]));
        }
        
        for (int i = 0; i < k-1; i++) {
            Tuple tuple = heap.poll();
            if (tuple.row < n-1) {
                heap.add(new Tuple(tuple.row+1, tuple.col, matrix[tuple.row+1][tuple.col]));
            }
        }
        
        return heap.poll().val;
    }
    
    
    class Tuple implements Comparable<Tuple> {
        int row;
        int col;
        int val;
        
        public Tuple (int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
        
        public int compareTo(Tuple other) {
            return this.val - other.val;
        }
    }
}
