import java.util.*;

public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        
        int max = 0;
        
        for (int i = 0; i < points.length; i++) {
            int same = 0;
            int vert = 0;
            Map<String, Integer> map = new HashMap<String, Integer>();
            int localMax = 0;
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        same++;
                    } else {
                        vert++;
                    }
                } else {
                    int xDiff = points[i].x - points[j].x;
                    int yDiff = points[i].y - points[j].y;
                    int gcd = gcd(xDiff, yDiff);
                    if (gcd != 0) {
                        xDiff /= gcd;
                        yDiff /= gcd;
                    }
                    String slope = xDiff + "," + yDiff;
                    if (map.containsKey(slope)) {
                        map.put(slope, map.get(slope) + 1);
                    } else {
                        map.put(slope, 1);
                    }
                }
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                localMax = Math.max(localMax, entry.getValue());
            }
            
            localMax = Math.max(localMax, vert);
            max = Math.max(max, localMax+same);
        }
    
        return max+1;
        
    }
    
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    
    class Point {
    	int x;
    	int y;
    	Point() { x = 0; y = 0; }
    	Point(int a, int b) { x = a; y = b; }
    }
}
