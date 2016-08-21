
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null) return;
        boolean odd = false;
        for (int i = 0; i < nums.length-1; i++) {
            if ((!odd && nums[i] > nums[i+1]) || (odd && nums[i] < nums[i+1])) {
                nums[i+1] += nums[i];
                nums[i] = nums[i+1] - nums[i];
                nums[i+1] -= nums[i];
            }
            
            odd = !odd;
        }
        
        return;
        
    }
}
