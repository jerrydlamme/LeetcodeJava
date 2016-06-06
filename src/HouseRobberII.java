
public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        int max = 0;
        
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        int[] opt = new int[n];
        
        opt[0] = nums[0];
        opt[1] = nums[0];
        for (int i = 2; i < n-1; i++) {
            opt[i] = Math.max(opt[i-2] + nums[i], opt[i-1]);
        }
        
        max = opt[n-2];
        
        opt[1] = nums[1];
        opt[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            opt[i] = Math.max(opt[i-2] + nums[i], opt[i-1]);
        }
        
        max = opt[n-1] > max ? opt[n-1] : max;
        
        return max;
    }
}
