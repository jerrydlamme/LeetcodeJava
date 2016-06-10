import java.util.*;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        int[] roll = new int[k];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += 9 - i;
        }
        if (n > sum) return lists;
        
        
        sub(lists, 0, n, 1, roll);
        return lists;
    }
    
    void sub(List<List<Integer>> lists, int index, int target, int digit, int[] roll) {
        if (index > roll.length || digit > 9 || digit > target) return;
        
        if (index == roll.length-1) {
            if (target >= digit && target <= 9) {
                roll[index] = target;
                List<Integer> list = new LinkedList<Integer>();
                for (int i = 0; i < roll.length; i++) {
                    list.add(roll[i]);
                }
                lists.add(list);
            }
            return;
        }
        
        sub(lists, index, target, digit+1, roll);
        
        roll[index] = digit;
        sub(lists, index+1, target-digit, digit+1, roll);
    }
}
