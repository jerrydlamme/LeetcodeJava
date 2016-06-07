
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            max = pre > max ? pre : max;
            if (pre <= 0) {
                pre = 0;
            }
            
        }
        
        return max;
    }
}
