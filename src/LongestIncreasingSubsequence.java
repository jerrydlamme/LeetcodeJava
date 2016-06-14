import java.util.*;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        List<Integer> opt = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            
            if (opt.size() == 0) {
                opt.add(target);
            } else {
                int left = 0, right = opt.size() - 1;
                int mid = 0, mid_val = 0;
                while (left <= right) {
                    mid = (left + right)/2;
                    mid_val = opt.get(mid);
                    if (mid_val == target) {
                        opt.set(mid, mid_val);
                        break;
                    } else if (mid_val < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                
                if (left > right) {
                    if (left == opt.size()) {
                        opt.add(target);
                    } else {
                        opt.set(left, target);
                    }
                }
            }
        }
        
        return opt.size();
    }
	
}
