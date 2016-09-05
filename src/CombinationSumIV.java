
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] opt = new int[target+1];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= target) opt[nums[i]] = 1;
        }

        for (int i = 1; i < opt.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 1) opt[i] += opt[i - nums[j]];
            } 
        }

        return opt[target];
    }
}
