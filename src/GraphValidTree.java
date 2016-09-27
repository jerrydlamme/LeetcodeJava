
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        
        for (int i = 0; i < edges.length; i++) {
            int r1 = root(arr, edges[i][0]);
            int r2 = root(arr, edges[i][1]);
            if (r1 == r2) return false;
            arr[r1] = r2;
        }
        
        return true;
    }
    
    int root(int[] arr, int index) {
        int i = index;
        while (arr[index] != index) {
            arr[index] = arr[arr[index]];
            index = arr[index];
        }
        
        return index;
    }
}
