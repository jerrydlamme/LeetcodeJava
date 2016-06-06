
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        /*
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i])
                return i;
        }
        
        return nums.length;
        */
        int i = 0, j = nums.length-1;
        while (i <= j) {
            int mid = (i+j)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                if (mid + 1 < nums.length && nums[mid+1]>target) {
                    return mid+1;
                } else if ( mid == nums.length-1) {
                    return mid+1;
                }
                
                i = mid+1;
            } 
            if (nums[mid] > target) {
                if (mid-1 >= 0 && nums[mid-1] < target) {
                    return mid;
                } else if (mid == 0) {
                    return 0;
                }
                
                j = mid - 1;
            }
        }
        
        return -1;
    }
}
