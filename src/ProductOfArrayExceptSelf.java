
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) return null;
        int len = nums.length;
        int[] pro = new int[len];
        pro[0] = 1;
        int holder = nums[0];
        
        for (int i = 1; i < len; i++) {
            pro[i] = holder;
            holder *= nums[i];
        }
        
        holder = nums[len-1];
        for (int i = len - 2; i >= 0; i--) {
            pro[i] *= holder;
            holder *= nums[i];
        }
        
        return pro;
    }
}
