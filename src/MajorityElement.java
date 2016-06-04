
public class MajorityElement {
	public int majorityElement(int[] nums) {
        int maj = 0, count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                maj = nums[i];
                count = 1;
            } else if (maj == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        
        return maj;
    }
}
