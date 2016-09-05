import java.util.*;

public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        if (nums == null) return res;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (sum == k) {
                res = i + 1;
            } else {
                int offset = sum - k;
                if (map.containsKey(offset)) {
                    res = Math.max(res, i - map.get(offset));
                }
            }
            
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return res;
    }
}
