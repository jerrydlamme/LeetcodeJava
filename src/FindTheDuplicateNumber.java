
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i+1) {
                tmp = nums[i];
                if (nums[i] != nums[nums[i]-1]) {
                    nums[i] = nums[nums[i]-1];
                    nums[tmp-1] = tmp;
                } else {
                    return tmp;
                }
            }
        }
        
        return nums[nums.length-1];
    }
}
