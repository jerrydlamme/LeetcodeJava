import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(0);
            return list;
        }
        
        Set<Integer>[] topo = new Set[n];
        
        for (int i = 0; i < n; i++) topo[i] = new HashSet<Integer>(); 
        
        for (int[] edge : edges) {
            topo[edge[0]].add(edge[1]);
            topo[edge[1]].add(edge[0]);
        }
        
        List<Integer> leaves = new LinkedList<Integer>();
        
        for (int i = 0; i < topo.length; i++) {
            if (topo[i].size() == 1) leaves.add(i);
        }
        
        while (n > 2) {
            n -= leaves.size();
            List<Integer> nextLeaves = new LinkedList<Integer>();
            for (Integer leaf : leaves) {
                int par = topo[leaf].iterator().next();
                topo[par].remove(leaf);
                if (topo[par].size() == 1) nextLeaves.add(par);
            }
            
            leaves = nextLeaves;
        }
        
        return leaves;
    }
}
