import java.util.*;
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        return permRec(nums, nums.length-1);   
    }
    
    List<List<Integer>> permRec(int[] nums, int index) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (index < 0) return lists;
            
        if (index == 0) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(nums[index]);
            lists.add(list);
            return lists;
        }
            
        List<List<Integer>> prevs = permRec(nums, index-1);
        for (List<Integer> list : prevs) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> base = new LinkedList<Integer>(list);
                base.add(i, nums[index]);
                lists.add(base);
            }
         
        }
            
        return lists;
    }
}
