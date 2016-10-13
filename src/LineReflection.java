import java.util.*;

public class LineReflection {
    public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        
        for (int i = 0; i < points.length; i++) {
            min = min > points[i][0] ? points[i][0] : min;
            max = max < points[i][0] ? points[i][0] : max;
            if (map.containsKey(points[i][0])) {
                map.get(points[i][0]).add(points[i][1]);
            } else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(points[i][1]);
                map.put(points[i][0], set);
            }
        }
        
        int axe = (min + max);
        
        for (int i = 0; i < points.length; i++) {
            int refx = axe - points[i][0];
            if (!map.containsKey(refx)) {
                return false;
            } else {
                if (!map.get(refx).contains(points[i][1])) return false;
            }
        }
        
        return true;
    }
}
