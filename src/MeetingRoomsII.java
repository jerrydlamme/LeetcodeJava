import java.util.Arrays;;

public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
    
        
        int[] ends = new int[intervals.length];
        int[] starts = new int[intervals.length];
        for (int i = 0; i < ends.length; i++) {
            ends[i] = intervals[i].end;
            starts[i] = intervals[i].start;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
    
        int max = 0;
        int k = 0;
        for (int i = 0; i < ends.length; i++) {
            while (k < starts.length && starts[k] < ends[i]) k++;
            max = Math.max(k - i, max);
        }
    
        return max;
    }
}
