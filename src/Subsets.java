import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return null;
        
        if (nums.length == 0) {
            return new LinkedList<List<Integer>>();
        }
        
        return sub(nums, nums.length-1);
    }
    
    List<List<Integer>> sub(int[] nums, int index) {
        List<List<Integer>> lists, updates;
        
        if (index == 0) {
            lists = new LinkedList<List<Integer>>();
            lists.add(new LinkedList<Integer>());
            List<Integer> list = new LinkedList<Integer>();
            list.add(nums[0]);
            lists.add(list);
            return lists;
        }
        
        lists = sub(nums, index - 1);
        updates = new LinkedList<List<Integer>>();
        for (List<Integer> list : lists) {
            List<Integer> update = new LinkedList<Integer>(list);
            update.add(nums[index]);
            updates.add(update);
        }
        
        lists.addAll(updates);
        
        return lists;
    }
}
