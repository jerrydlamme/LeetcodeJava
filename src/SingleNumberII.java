
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int result = 0;
        int count = 0;
        
        
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    count++;
                }
            }
            
            result |= (count%3) << i;
            count = 0;
        }
        
        return result;
    }
}
