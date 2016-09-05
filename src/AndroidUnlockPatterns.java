
public class AndroidUnlockPatterns {
    boolean[] mask = new boolean[10];
    int[] opt = new int[10];
    int m;
    int n;
    int count = 0;
    
    public int numberOfPatterns(int m, int n) {
        this.m = m;
        this.n = n;
        rec(1);
        
        return count;
    }
    
    void rec(int index) {
        if (index-1 >= m && index-1 <= n) count++;
        
        if (index <= n) {
            for (int i = 1; i <= 9; i++) {
                if (mask[i]) continue;
                
                if (index >= 2) {
                    int j = opt[index-1];
                    if (!leagal(j, i)) continue;
                }
                
                opt[index] = i;
                mask[i] = true;
                rec(index+1);
                mask[i] = false;
            }
        }
    }
    
    boolean leagal(int a, int b) {
        int i = (a-1)/3;
        int j = (a-1)%3;
        int x = (b-1)/3;
        int y = (b-1)%3;
        
        int xd = Math.abs(i-x);
        int yd = Math.abs(j-y);
        if ((xd == 0 || xd == 2) && (yd == 0 || yd == 2)) {
            return mask[(a+b)/2];
        }
        
        return true;
    }
}
