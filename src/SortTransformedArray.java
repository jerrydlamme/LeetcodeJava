
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] arr = new int[nums.length];
        
        if (a == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (b < 0) {
                    arr[i] = nums[nums.length - 1 - i];
                } else {
                    arr[i] = nums[i];
                }
                
            }
        } else {
            double axe = 0 - (double)b/(2*(double)a);
            int nearest = binarySearch(nums, axe);
            
            if (a > 0) {
                int left = nearest - 1;
                int right = nearest;
                
                int cur = 0;
                
                while (left >= 0 && right <= nums.length-1) {
                    if (axe - (double)nums[left] <= (double)nums[right] - axe) {
                        arr[cur++] = nums[left--];
                    } else {
                        arr[cur++] = nums[right++];
                    }
                }
                
                while (left >= 0) {
                    arr[cur++] = nums[left--];
                }
                while (right <= nums.length-1) {
                    arr[cur++] = nums[right++];
                }
            } else {
                int left = 0;
                int right = nums.length-1;
                int cur = 0;
                
                while (left < nearest && right >= nearest) {
                    if ((double)nums[right] - axe >= axe - (double)nums[left]) {
                        arr[cur++] = nums[right--];
                    } else {
                        arr[cur++] =  nums[left++];
                    }
                }
                
                while (left < nearest) {
                    arr[cur++] = nums[left++]; 
                }
                
                while (right >= nearest) {
                    arr[cur++] = nums[right--];
                }
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a * arr[i] * arr[i] +  b * arr[i] + c;
        }
        
        return arr;
    }
    
    int binarySearch(int[] nums, double axe) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right)/2;
            if (nums[mid] == axe) {
                return mid;
            } else if (nums[mid] < axe) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}
