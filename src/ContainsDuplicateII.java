import java.util.*;
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return false;
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i-k-1]);
            }
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        
        return false;
    }
}
