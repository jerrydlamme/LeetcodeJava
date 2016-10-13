
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            if (sum < s) 
                end++;
            else 
                break;
        }
        if (end >= nums.length) return 0;
        min = end - start + 1;
        
        System.out.println(min + " " + end);
        
        while (end < nums.length) {
            while (sum - nums[start] >= s) {
                sum -= nums[start++];
            }
            min = Math.min(min, end - start + 1);
            end++;
            if (end < nums.length) sum += nums[end];
        }
        
        return min;
    }
}
