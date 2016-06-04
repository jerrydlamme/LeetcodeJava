
public class MoveZeros {
	public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                if (i < j) nums[j] = 0;
                i++;
            }
        }
    }
}
