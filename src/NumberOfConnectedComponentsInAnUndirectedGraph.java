
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        if (n < 2 || edges.length == 0) return n;
        
        int size = n;
        
        int[] opt = new int[n];
        for (int i = 0; i < opt.length; i++) {
            opt[i] = i;
        }
        
        for (int i = 0; i < edges.length; i++) {
            if (union(edges[i][0], edges[i][1], opt)) {
                size--;
            }
        }

        return size;
    
    }
    
    int root(int i, int[] opt) {
        while (i != opt[i]) {
            opt[i] = opt[opt[i]];
            i = opt[i];
        }
        return i;
    }
        
    boolean union(int i, int j, int[] opt) {
        i = root(i, opt);
        j = root(j, opt);
        
        if (i == j) {
            return false;
        } else {
            opt[i] = j;
            return true;
        }
    }
}
