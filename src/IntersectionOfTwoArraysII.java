import java.util.*;
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        
        List<Integer> list = new LinkedList<Integer>();
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                int count = map.get(nums1[i]);
                count++;
                map.put(nums1[i], count++);
            } else {
                map.put(nums1[i], 1);
            }
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                int count = map.get(nums2[i]);
                if (count > 0) {
                    list.add(nums2[i]);
                    map.put(nums2[i], count-1);
                }
            }
        }
        
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  list.get(i);
        }
        
        return arr;
    }
}
