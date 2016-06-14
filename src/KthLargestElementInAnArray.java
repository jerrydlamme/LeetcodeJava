import java.util.*;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        
        int ret = 0;
        
        for (int i = 0; i <= nums.length - k; i++) {
            ret = queue.poll();
        }
        
        return ret;
    }
}
