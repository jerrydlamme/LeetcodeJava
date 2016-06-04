
public class CountingBits {
	public int[] countBits(int num) {
        if (num < 0) return null;
        int[] arr = new int[num+1];
        
        for(int i = 1, j = 1; i <= num; i++) {
            arr[i] = arr[i-j] + 1;
            if ((i + 1) == 2 * j) j *= 2;
        }
        
        return arr;
    }
}
