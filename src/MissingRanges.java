import java.util.*;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new LinkedList<String>();
        int ind = 0, cur = lower;
        
        for (; ind < nums.length; ind++) {
            if (nums[ind] == cur) {
                cur++;
                continue;
            }
            
            if (nums[ind] > cur) {
                if (nums[ind] - 1 == cur) {
                    list.add(cur + "");
                } else {
                    list.add(cur + "->" + (nums[ind]-1));
                }
                cur = nums[ind] + 1;
            }
        }
        
        if (cur == upper) {
            list.add(upper + "");
        } else if (upper > cur ){
            list.add(cur + "->" + upper);
        }
        
        return list;
    }
}
