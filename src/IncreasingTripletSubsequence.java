
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        
        int upperBound = Integer.MAX_VALUE; 
        int lowerBound = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > upperBound) return true;
            
            if (nums[i] > nums[i-1]) {
                if (nums[i-1] < lowerBound) {
                    lowerBound = nums[i-1];
                }
            }
            
            if (nums[i] > lowerBound && nums[i] < upperBound) {
                upperBound = nums[i];
            }
        }
        
        return false;
    }
}
