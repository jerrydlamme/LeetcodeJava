import java.util.*;

public class DesignHitCounter {

    List<Wrapper> list;

    /** Initialize your data structure here. */
    public DesignHitCounter() {
        list = new ArrayList<Wrapper>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (list.size() == 0) {
            Wrapper wp = new Wrapper(timestamp);
            wp.hits++;
            list.add(wp);
        } else {
            Wrapper latest = list.get(list.size()-1);
            if (latest.ts < timestamp) {
                Wrapper wp = new Wrapper(timestamp);
                wp.hits += latest.hits + 1;
                list.add(wp);
            } else {
                latest.hits++;
            }
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (list.size() == 0 || timestamp < list.get(0).ts || timestamp-300 >= list.get(list.size()-1).ts) return 0;
        
        return bs(list, timestamp) - bs(list, timestamp-300);
    }
    
    int bs(List<Wrapper> list, int timestamp) {
        if (timestamp < list.get(0).ts) return 0;
        
        int left = 0, right = list.size()-1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right)/2;
            Wrapper wp = list.get(mid);
            if (wp.ts == timestamp) {
                return wp.hits;
            } else if (wp.ts < timestamp) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        Wrapper wp = list.get(right);
        return wp.hits;
    }
    
    
    
    class Wrapper {
        int ts;
        int hits;
        
        Wrapper(int timestamp) {
            this.ts = timestamp;
            hits = 0;
        }
    }
}
