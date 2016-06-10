import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        
        if (candidates == null || candidates.length == 0)   return lists;
        
        Arrays.sort(candidates);
        
        int[] nums = new int[candidates.length];
        
        sub(lists, candidates, target, 0, nums);
        return lists;
    }
    
    void sub(List<List<Integer>> lists, int[] candidates, int target, int index, int[] nums) {
        if (index >= candidates.length || target < 0) return; 
        int base = candidates[index];
        
        nums[index] = 0;
        sub(lists, candidates, target, index+1, nums);

        if (index > 0 && candidates[index] == candidates[index-1] && nums[index-1] == 0) {
            return;
        }

        if (target > base) {
            nums[index] = 1;
            sub(lists, candidates, target-base, index+1, nums);
        } else if (target == base) {
            List<Integer> list = new LinkedList<Integer>();
            for(int i = 0; i < index; i++) {
                for(int j = 0; j < nums[i]; j++) {
                    list.add(candidates[i]);
                }
            }
            list.add(base);
            lists.add(list);
            return;
        }
    
        return;
    }
}
