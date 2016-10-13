import java.util.*;
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) return list;
        
        int count1 = 0, count2 = 0, maj1 = nums[0], maj2 = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maj1) {
                count1++;
            } else if (nums[i] == maj2) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                maj1 = nums[i];
            } else if (count2 == 0) {
                count2++;
                maj2 = nums[i];
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maj1) {
                count1++;
            } else if (nums[i] == maj2) {
                count2++;
            }
        }
        
        if (count1 > nums.length/3) list.add(maj1);
        if (count2 > nums.length/3) list.add(maj2);
        
        return list;
    }
}
