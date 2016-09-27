import java.util.*;

public class RandomPickIndex {
    
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    Random random;

    public RandomPickIndex(int[] nums) {
        this.random  = new Random();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new LinkedList<Integer>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
    }
    
    public int pick(int target) {
        if (map.containsKey(target)) {
            List<Integer> list = map.get(target);
            int next = random.nextInt(list.size());
            return list.get(next);
        } else {
            return -1;
        }
    }
}
