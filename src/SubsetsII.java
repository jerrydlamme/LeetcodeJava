import java.util.*;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) return null;
        
        if (nums.length == 0) {
            return new LinkedList<List<Integer>>();
        }
        
        Arrays.sort(nums);
        int[] last = new int[1];
        
        return sub(nums, nums.length-1, last);
           
    }
    
    List<List<Integer>> sub(int[] nums, int index, int[] last) {
        List<List<Integer>> lists, updates;
        
        if (index == 0) {
            lists = new LinkedList<List<Integer>>();
            lists.add(new LinkedList<Integer>());
            List<Integer> list = new LinkedList<Integer>();
            list.add(nums[0]);
            lists.add(list);
            last[0] = 1;
            return lists;
        }
        
        lists = sub(nums, index - 1, last);
        int count = 0;
        updates = new LinkedList<List<Integer>>();
        if (nums[index] != nums[index-1]) {
            for (List<Integer> list : lists) {
                List<Integer> update = new LinkedList<Integer>(list);
                update.add(nums[index]);
                updates.add(update);
                count++;
            }
        } else {
            for (int i = lists.size()-1; i >= lists.size()-last[0]; i--) {
                List<Integer> update = new LinkedList<Integer>(lists.get(i));
                update.add(nums[index]);
                updates.add(update);
                count++;
            }
        }
        
        last[0] = count;
        
        lists.addAll(updates);
        
        return lists;
    }
}
