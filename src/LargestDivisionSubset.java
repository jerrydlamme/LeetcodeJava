import java.util.*;

public class LargestDivisionSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) return list;
        
        Arrays.sort(nums);
        
        int[] opt = new int[nums.length];
        int[] skew = new int[nums.length];
        
        int index = 0;
        int len = 1;
        
        opt[0] = 1;
        skew[0] = 0;
        
        for (int i = 1; i < nums.length; i++) {
            int last_index = -1;
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && opt[j] > max) {
                    max = opt[j];
                    last_index = j;
                }
            }
            opt[i] = max+1;
            if (max == 0) {
                skew[i] = i;   
            } else {
                skew[i] = last_index;
            }   
            
            if (opt[i] > len) {
                len = opt[i];
                index = i;
            }
        }
        
        while (index != skew[index]) {
            list.add(nums[index]);
            index = skew[index];
        }
        list.add(nums[index]);
        
        return list;
    }
}
