
public class WiggleSequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        
        int max = 1;
        int state = 0;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) continue;
            
            if (state == 0) {
                max++;
                if (nums[i] > last) {
                    state = 1;
                } else {
                    state = 2;
                }
            } else if (state == 1) {
                if (nums[i] < last) {
                    max++;
                    state = 2;
                }
            } else {
                if (nums[i] > last) {
                    max++;
                    state = 1;
                }
            }
            last = nums[i];
        }
        
        return max;
    }
}
