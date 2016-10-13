import java.util.*;

public class DesignPhoneDirectory {
    
    Set<Integer> pool;
    int size;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        size = maxNumbers;
        pool = new HashSet<Integer>();
        for (int i = 0; i < size; i++) {
            pool.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (pool.isEmpty()) return -1;
        Iterator<Integer> it = pool.iterator();
        int num = it.next();
        it.remove();
    
        return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return pool.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
            if (number >= size) return;
            pool.add(number);
    }
}
