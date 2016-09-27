import java.util.*;

public class InsertDeleteGetRandom {
    Random random = new Random();
    List<Integer> list = new ArrayList<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        if (index < list.size()-1) {
            list.set(index, list.get(list.size()-1));
            map.put(list.get(index), index);
        }
        
        map.remove(val);
        list.remove(list.size()-1);
        
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
