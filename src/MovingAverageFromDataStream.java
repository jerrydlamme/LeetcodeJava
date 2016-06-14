import java.util.*;
public class MovingAverageFromDataStream {
    Deque<Integer> queue;
    int sum;
    int size;

    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        this.size = size;
        this.queue = new ArrayDeque<Integer>();
        sum = 0;
    }
    
    public double next(int val) {
        if (queue.size() < this.size) {
            sum += val;
        } else {
            sum += val - queue.poll();
        }
        queue.add(val);
        
        return (double)sum/queue.size();
    }
}
