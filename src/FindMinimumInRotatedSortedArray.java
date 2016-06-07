
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n <= 0) return 0;
        
        if (nums[0] <= nums[n-1]) return nums[0];
        
        int low = 0, high = n-1;
        
        int mid;
        while (low <= high) {
            mid = (low+high)/2;
            if (mid >= 1 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if (mid < n-1 && nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            
            if (nums[mid] > nums[n-1]) {
                low = mid+1;
            } else if (nums[mid] < nums[0]){
                high = mid - 1;
            }
            
        }
        
        return -1;
    }
}
