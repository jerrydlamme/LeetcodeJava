
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        if (height.length < 2) return max;
        int head = 0, tail = height.length-1;
        
        int area = 0;
        
        while (head < tail) {
            area = (tail - head) * Math.min(height[head], height[tail]);
            if (area > max) max = area;
            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        
        return max;
    }
}
