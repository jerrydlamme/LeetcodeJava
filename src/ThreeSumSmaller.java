import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) return 0;
        
        int sum = 0;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++) {
            int count = 0;
            int left = i+1, right = nums.length-1;
            int offset = target - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] < offset) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
            sum += count;
        }
        
        return sum;
    }
}
