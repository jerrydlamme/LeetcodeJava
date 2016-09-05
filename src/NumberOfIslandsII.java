import java.util.*;

public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] opt = new int[m][n];
        
        List<Integer> list = new LinkedList<Integer>();
        int islands = 0;
        
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            
            if (opt[x][y] == 0) {
                islands++;
                opt[x][y] = x * n + y + 1;
                
                if (x-1 >= 0 && opt[x-1][y] != 0) {
                    if (union(opt[x][y], opt[x-1][y], opt)) islands--;
                }
                
                if (y-1 >= 0 && opt[x][y-1] != 0) {
                    if (union(opt[x][y], opt[x][y-1], opt)) islands--;
                }
                
                if (x+1 < m && opt[x+1][y] != 0) {
                    if (union(opt[x][y], opt[x+1][y], opt)) islands--;
                }
                
                if (y+1 < n && opt[x][y+1] != 0) {
                    if (union(opt[x][y], opt[x][y+1], opt)) islands--;
                }
            }
            
            list.add(islands);
        }
        
        return list;
    }
    
    int root(int id, int[][] opt) {
        int n = opt[0].length;
        while (opt[(id-1)/n][(id-1)%n] != id) {
            int tmp = opt[(id-1)/n][(id-1)%n];
            opt[(id-1)/n][(id-1)%n] = opt[(tmp-1)/n][(tmp-1)%n];
            id = opt[(id-1)/n][(id-1)%n];
        }
        
        return id;
    }
    
    boolean union(int i, int j, int[][] opt) {
        int n = opt[0].length;
        i = root(i, opt);
        j = root(j, opt);
        
        if (i == j) {
            return false;
        } else {
            opt[(i-1)/n][(i-1)%n] = j;
            return true;
        }
    }
}
