import java.util.*;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return intervals;
        Interval[] its = new Interval[intervals.size()];
        its = intervals.toArray(its);
        
        Arrays.sort(its, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;    
            }
        });
        
        List<Interval> list = new LinkedList<Interval>();
        Interval cur = new Interval(its[0].start, its[0].end);
        if (its.length == 1) list.add(cur);
        
        for (int i = 1; i < its.length; i++) {
            if (its[i].start <= cur.end) {
                cur.end = Math.max(cur.end, its[i].end);
            } else {
                list.add(cur);
                cur = new Interval(its[i].start, its[i].end);
            }
            if (i == its.length - 1) list.add(cur);
        }
        
        return list;
    }
}
