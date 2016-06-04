
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int k = 0, xor = 0;
        int[] diffs = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        
        for (; k < 32; k++) {
            if (((xor >> k) & 1) == 1) break;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >> k) & 1) == 1) {
                diffs[0] ^= nums[i];
            } else {
                diffs[1] ^= nums[i];
            }
        }
        
        return diffs;
    }
}
