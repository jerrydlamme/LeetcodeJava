
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums.length < 2) return;
        int n = nums.length;
        int head = 0, tail = nums.length-1;
        for(; head < n; head++) {
            if (nums[head] != 0) break;
        }
        for(; tail >= 0; tail--) {
            if (nums[tail] != 2) break;
        }
        
        int p = head;
        while(p <= tail) {
            if (nums[p] == 0) {
                if (p > head) {
                    nums[p] = nums[head];
                    nums[head] = 0;
                    head++;
                } else {
                    p++;
                    head++;
                }
            } else if (nums[p] == 1) {
                p++;
            } else {
                nums[p] = nums[tail];
                nums[tail] = 2;
                tail--;
            }
        }
    }
}
