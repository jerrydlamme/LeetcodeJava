
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int[] arr = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                arr[0] = left+1;
                arr[1] = right+1;
                break;
            } else if (numbers[left] + numbers[right] < target) {
                while (numbers[left] == numbers[left+1]) {
                    left++;
                }
                left++;
            } else {
                while (numbers[right] == numbers[right-1]) {
                    right--;
                }
                right--;
            }
        }
        
        return arr;
    }
}
