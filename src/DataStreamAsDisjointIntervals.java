import java.util.*;

class Interval {
	int start;
	int end;
	
	public Interval() {
		this.start = 0;
		this.end = 0;
	};

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	};
}


public class DataStreamAsDisjointIntervals {
    List<Interval> list;

    /** Initialize your data structure here. */
    public DataStreamAsDisjointIntervals() {
        this.list = new LinkedList<Interval>();
    }
    
    public void addNum(int val) {
        if (list.isEmpty()) {
            list.add(new Interval(val, val));
            return;
        } 
        
        int left = 0, right = list.size()-1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            Interval it = list.get(mid);
            
            if (val >= it.start && val <= it.end) {
                return;
            } else if (val < it.start) {
                if (val == it.start - 1) {
                    it.start = val;
                    
                    if (mid >= 1) {
                        Interval neighbor = list.get(mid-1);
                        
                        if (neighbor.end == it.start-1) {
                            neighbor.end = it.end;
                            list.remove(mid);
                        } 
                    }
                    return;
                } else {
                    right = mid - 1;
                }
            } else {
                if (val == it.end + 1) {
                    it.end = val;
                    
                    if (mid <= list.size() - 2) {
                        Interval neighbor = list.get(mid+1);
                        
                        if (it.end == neighbor.start-1) {
                            neighbor.start = it.start;
                            list.remove(mid);
                        }
                    }
                    return;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        list.add(left, new Interval(val, val));
    }
    
    public List<Interval> getIntervals() {
        return list;
    }
}
