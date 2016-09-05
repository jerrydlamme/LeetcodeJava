import java.util.*;

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Wrapper[] arr = new Wrapper[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            arr[i] =  new Wrapper(intervals[i]);
        }
        
        Arrays.sort(arr);
        
        for (int i = 0; i < intervals.length-1; i++) {
            if (arr[i].interval.end > arr[i+1].interval.start) return false;
        }
        
        return true;
    }
}

class Wrapper implements Comparable<Wrapper> {
    Interval interval;
    
    Wrapper (Interval interval) {
        this.interval = interval;
    }
    
    public int compareTo(Wrapper other) {
        return this.interval.start - other.interval.start;
    }
}
