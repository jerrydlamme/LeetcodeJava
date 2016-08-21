import java.util.*;
public class LoggerRateLimiter {

    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
	            int last = map.get(message);
	            if (last > timestamp) return false;
	            
	            if (timestamp - last < 10) {
	                return false;
	            } else {
	                map.put(message, timestamp);
	                return true;
	            }
	        } else {
	            map.put(message, timestamp);
	            return true;
	        }
    }
}
