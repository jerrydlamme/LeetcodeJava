import java.util.*;
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        
        if (candidates == null || candidates.length == 0)   return lists;
        
        int[] nums = new int[candidates.length];
        
        sub(lists, candidates, target, 0, nums);
        return lists;
    }
    
    void sub(List<List<Integer>> lists, int[] candidates, int target, int index, int[] nums) {
        if (target == 0) {
            List<Integer> list = new LinkedList<Integer>();
            for(int i = 0; i < index; i++) {
                for(int j = 0; j < nums[i]; j++) {
                    list.add(candidates[i]);
                }
            }
            lists.add(list);
            return;
        } 
        
        if (index >= candidates.length) return; 
        int base = candidates[index];
        
        for (int i = 0; i <= target/base; i++) {
            nums[index] = i;
            sub(lists, candidates, target - i * base, index+1, nums);
        }
    }
}
