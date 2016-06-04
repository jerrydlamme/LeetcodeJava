import java.util.*;

public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        
        List<Integer> list = new LinkedList<Integer>();
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], 0);
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                int count = map.get(nums2[i]);
                if (count == 0) {
                    list.add(nums2[i]);
                    count++;
                    map.put(nums2[i], count);
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
